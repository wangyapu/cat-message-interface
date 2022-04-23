package com.dianping.cat.message.facade.client;

import java.util.List;

public interface MessageSender<T> {
    void sendMessage(List<T> dataList, String hashKey);


}
