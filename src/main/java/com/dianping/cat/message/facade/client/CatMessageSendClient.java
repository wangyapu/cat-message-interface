package com.dianping.cat.message.facade.client;

import com.dianping.cat.message.facade.dto.CatMessageDTO;
import com.dianping.cat.message.facade.proto.CatMessageCallServiceGrpc;
import com.dianping.cat.message.facade.proto.CatMessageData;
import com.dianping.cat.message.facade.proto.CatMessageRequest;
import com.dianping.cat.message.facade.proto.CatMessageResponse;
import com.dianping.cat.message.facade.rpc.GRpcCall;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CatMessageSendClient extends MessageSendClient {

    public CatMessageSendClient(ServerListLoader serverListLoader, ThreadPoolExecutor threadExecutor) {
        super(serverListLoader, threadExecutor);
    }

    public void sendMessage(List<CatMessageDTO> dataList, String hashKey) {
        if (dataList == null || dataList.isEmpty()) {
            return;
        }

        CatMessageRequest request = buildCatMessageRequest(dataList);

        GRpcCall<CatMessageRequest, CatMessageResponse> call = new GRpcCall<>(pool, hashKey, request);
        call.asyncCall((rpcStateChannel, catMessageRequest) -> CatMessageCallServiceGrpc.newFutureStub(rpcStateChannel.getChannel())
                .withDeadlineAfter(5, TimeUnit.SECONDS).onMessage(request));

        threadExecutor.execute(() -> {
            try {
                call.getWithRetry();
            } catch (Exception e) {
                // ignore
            }
        });
    }

    private CatMessageRequest buildCatMessageRequest(List<CatMessageDTO> dataList) {
        List<CatMessageData> calObs = new ArrayList<>();
        for (CatMessageDTO catMessageDTO : dataList) {
            CatMessageData data = CatMessageData.newBuilder().setPeriod(catMessageDTO.getPeriod()).build();
            calObs.add(data);
        }

        return CatMessageRequest.newBuilder().addAllDataList(calObs).build();
    }

}
