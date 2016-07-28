package com.syl.data.mapper;

import com.syl.data.model.NotificationEntity;
import com.syl.domain.model.Notification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shen YunLong on 2016/06/24.
 */
public class NotificationMapper {

    public static Notification transform(NotificationEntity entity) {
        if (entity == null) {
            return null;
        }

        Notification notification = new Notification();

        notification.setId(entity.getId());
        notification.setRepository(RepositoryMapper.transform(entity.getRepository()));
        notification.setReason(entity.getReason());
        notification.setUnread(entity.isUnread());
        notification.setUpdated_at(entity.getUpdated_at());
        notification.setLast_read_at(entity.getLast_read_at());
        notification.setUrl(entity.getUrl());

        if (entity.getSubject() != null) {
            Notification.SubjectBean subject = new Notification.SubjectBean();
            subject.setTitle(entity.getSubject().getTitle());
            subject.setUrl(entity.getSubject().getUrl());
            subject.setLatest_comment_url(entity.getSubject().getLatest_comment_url());
            subject.setType(entity.getSubject().getType());
            notification.setSubject(subject);
        }

        return notification;
    }

    public static List<Notification> transform(List<NotificationEntity> entityList) {
        List<Notification> notifications = new ArrayList<>();

        for (NotificationEntity entity : entityList) {
            Notification notification = transform(entity);
            if (notification != null) {
                notifications.add(notification);
            }
        }

        return notifications;
    }
}
