package com.syl.data.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.syl.basecore.json.SugarJson;
import com.syl.data.model.EventEntity;
import com.syl.data.model.event.CreateEventEntity;
import com.syl.data.model.event.ForkEventEntity;
import com.syl.data.model.event.MemberEventEntity;
import com.syl.data.model.event.WatchEventEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Data层Json数据解析逻辑
 * <p>
 * Created by Shen YunLong on 2016/06/25.
 */
public class GitHubJson extends SugarJson {

    public static List<EventEntity> parseEventList(final String json) {
        List<EventEntity> list = new ArrayList<>();

        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(json).getAsJsonArray();

        for (JsonElement element : array) {
            String type = element.getAsJsonObject().get("type").getAsString();

            EventEntity event = parseEvent(type, element);
            if (event != null) {
                list.add(event);
            }
        }

        return list;
    }

    public static EventEntity parseEvent(final String type, final JsonElement element) {
        // 将出现概率高的判断放在前面
        if (type.equals(WatchEventEntity.TYPE)) {
            // WatchEvent
            return fromJson(element, WatchEventEntity.class);
        } else if (type.equals(CreateEventEntity.TYPE)) {
            // CreateEvent
            return fromJson(element, CreateEventEntity.class);
        } else if (type.equals(ForkEventEntity.TYPE)) {
            // ForkEvent
            return fromJson(element, ForkEventEntity.class);
        } else if (type.equals(MemberEventEntity.TYPE)) {
            // MemberEvent
            return fromJson(element, MemberEventEntity.class);
        } else {
            // TODO: 16/6/25 后续添加其他Event类型
            return null;
        }
    }
}
