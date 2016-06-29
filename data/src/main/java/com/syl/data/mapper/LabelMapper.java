package com.syl.data.mapper;

import com.syl.data.model.LabelEntity;
import com.syl.domain.model.Label;

/**
 * @see Label
 * @see LabelEntity
 * Created by Shen YunLong on 2016/06/27.
 */
public class LabelMapper {

    public static Label transform(LabelEntity entity) {
        if (entity == null) {
            return null;
        }

        Label label = new Label();

        label.setUrl(entity.getUrl());
        label.setName(entity.getName());
        label.setColor(entity.getColor());

        return label;
    }
}
