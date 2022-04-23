package com.dianping.cat.message.facade.util;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class MurmurHash {

    @SuppressWarnings("UnstableApiUsage")
    public static Long hash(String key) {
        return Hashing.murmur3_128().hashString(key, StandardCharsets.UTF_8).asLong();
    }
}
