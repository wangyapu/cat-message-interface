package com.dianping.cat.message.facade.client;

import com.dianping.cat.message.facade.dto.CatMessageDTO;
import com.dianping.cat.message.facade.proto.CatMessageData;
import com.dianping.cat.message.facade.proto.CatMessageRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class CatMessageSendClient extends MessageSendClient {

    public CatMessageSendClient(ServerListLoader serverListLoader, ThreadPoolExecutor threadExecutor) {
        super(serverListLoader, threadExecutor);
    }

    public void sendMessage(List<CatMessageDTO> dataList, String hashKey) {
        if (dataList == null || dataList.isEmpty()) {
            return;
        }

        CatMessageRequest requests = buildCatMessageRequest(dataList);

        threadExecutor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

    }

    private CatMessageRequest buildCatMessageRequest(List<CatMessageDTO> dataList) {
        List<CatMessageData> calObs = new ArrayList<>();
        for (CatMessageDTO catMessageDTO : dataList) {
            CatMessageData data = CatMessageData.newBuilder().setPeriod(catMessageDTO.getPeriod()).build();
            calObs.add(data);
        }

        CatMessageRequest request = CatMessageRequest.newBuilder().addAllDataList(calObs).build();

        return null;
    }


}
