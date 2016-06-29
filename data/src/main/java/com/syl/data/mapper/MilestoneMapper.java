package com.syl.data.mapper;

import com.syl.data.model.MilestoneEntity;
import com.syl.domain.model.Milestone;

/**
 * @see Milestone
 * @see MilestoneEntity
 * Created by Shen YunLong on 2016/06/27.
 */
public class MilestoneMapper {

    public static Milestone transform(MilestoneEntity entity) {
        if (entity == null) {
            return null;
        }

        Milestone milestone = new Milestone();

        milestone.setUrl(entity.getUrl());
        milestone.setHtml_url(entity.getHtml_url());
        milestone.setLabels_url(entity.getLabels_url());
        milestone.setId(entity.getId());
        milestone.setNumber(entity.getNumber());
        milestone.setState(entity.getState());
        milestone.setTitle(entity.getTitle());
        milestone.setDescription(entity.getDescription());
        milestone.setCreator(UserMapper.transform(entity.getCreator()));
        milestone.setOpen_issues(entity.getOpen_issues());
        milestone.setClosed_issues(entity.getClosed_issues());
        milestone.setCreated_at(entity.getCreated_at());
        milestone.setUpdated_at(entity.getUpdated_at());
        milestone.setClosed_at(entity.getClosed_at());
        milestone.setDue_on(entity.getDue_on());

        return milestone;
    }

}
