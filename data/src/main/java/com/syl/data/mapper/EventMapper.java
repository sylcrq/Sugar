package com.syl.data.mapper;


import com.syl.data.model.event.CreateEventEntity;
import com.syl.data.model.EventEntity;
import com.syl.data.model.event.ForkEventEntity;
import com.syl.data.model.event.MemberEventEntity;
import com.syl.data.model.event.WatchEventEntity;
import com.syl.domain.model.event.CreateEvent;
import com.syl.domain.model.Event;
import com.syl.domain.model.event.ForkEvent;
import com.syl.domain.model.event.MemberEvent;
import com.syl.domain.model.event.WatchEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * @see Event
 * @see EventEntity
 * Created by Shen YunLong on 2016/04/27.
 */
public class EventMapper {

    public static Event transform(EventEntity entity) {
        if (entity == null) {
            return null;
        }

        Event event = null;

        if (entity instanceof WatchEventEntity) {
            event = new WatchEvent();
            transform4Watch(event, entity);
        } else if (entity instanceof CreateEventEntity) {
            event = new CreateEvent();
            transform4Create(event, entity);
        } else if (entity instanceof ForkEventEntity) {
            event = new ForkEvent();
            transform4Fork(event, entity);
        } else if (entity instanceof MemberEventEntity) {
            event = new MemberEvent();
            transform4Member(event, entity);
        }

        return event;
    }

    public static List<Event> transform(List<EventEntity> entityList) {
        List<Event> list = new ArrayList<>();

        for (EventEntity entity : entityList) {
            Event event = transform(entity);
            if (event != null) {
                list.add(event);
            }
        }

        return list;
    }

    private static void doBaseTransform(Event event, EventEntity entity) {
        event.setType(entity.getType());
        event.setPublicX(entity.isPublicX());
        event.setRepo(RepositoryMapper.transform(entity.getRepo()));
        event.setActor(UserMapper.transform(entity.getActor()));
        event.setOrg(OrganizationMapper.transform(entity.getOrg()));
        event.setCreated_at(entity.getCreated_at());
        event.setId(entity.getId());
    }

    private static void transform4Create(Event event, EventEntity entity) {
        doBaseTransform(event, entity);

        if (event instanceof CreateEvent && entity instanceof CreateEventEntity) {
            CreateEvent createEvent = (CreateEvent) event;
            CreateEventEntity createEventEntity = (CreateEventEntity) entity;

            if (createEventEntity.getPayload() != null) {
                CreateEvent.PayloadBean payload = new CreateEvent.PayloadBean();

                payload.setRef(createEventEntity.getPayload().getRef());
                payload.setRef_type(createEventEntity.getPayload().getRef_type());
                payload.setMaster_branch(createEventEntity.getPayload().getMaster_branch());
                payload.setDescription(createEventEntity.getPayload().getDescription());
                payload.setPusher_type(createEventEntity.getPayload().getPusher_type());
                payload.setRepository(RepositoryMapper.transform(createEventEntity.getPayload().getRepository()));
                payload.setSender(UserMapper.transform(createEventEntity.getPayload().getSender()));

                createEvent.setPayload(payload);
            }
        }
    }

    private static void transform4Fork(Event event, EventEntity entity) {
        doBaseTransform(event, entity);

        if (event instanceof ForkEvent && entity instanceof ForkEventEntity) {
            ForkEvent forkEvent = (ForkEvent) event;
            ForkEventEntity forkEventEntity = (ForkEventEntity) entity;

            if (forkEventEntity.getPayload() != null) {
                ForkEvent.PayloadBean payload = new ForkEvent.PayloadBean();

                if (forkEventEntity.getPayload().getForkee() != null) {
                    ForkEvent.PayloadBean.ForkeeBean forkee = new ForkEvent.PayloadBean.ForkeeBean();

                    forkee.setId(forkEventEntity.getPayload().getForkee().getId());
                    forkee.setName(forkEventEntity.getPayload().getForkee().getName());
                    forkee.setFull_name(forkEventEntity.getPayload().getForkee().getFull_name());
                    forkee.setOwner(UserMapper.transform(forkEventEntity.getPayload().getForkee().getOwner()));
                    forkee.setPrivateX(forkEventEntity.getPayload().getForkee().isPrivateX());
                    forkee.setHtml_url(forkEventEntity.getPayload().getForkee().getHtml_url());
                    forkee.setDescription(forkEventEntity.getPayload().getForkee().getDescription());
                    forkee.setFork(forkEventEntity.getPayload().getForkee().isFork());
                    forkee.setUrl(forkEventEntity.getPayload().getForkee().getUrl());
                    forkee.setForks_url(forkEventEntity.getPayload().getForkee().getForks_url());
                    forkee.setKeys_url(forkEventEntity.getPayload().getForkee().getKeys_url());
                    forkee.setCollaborators_url(forkEventEntity.getPayload().getForkee().getCollaborators_url());
                    forkee.setTeams_url(forkEventEntity.getPayload().getForkee().getTeams_url());
                    forkee.setHooks_url(forkEventEntity.getPayload().getForkee().getHooks_url());
                    forkee.setIssue_events_url(forkEventEntity.getPayload().getForkee().getIssue_events_url());
                    forkee.setEvents_url(forkEventEntity.getPayload().getForkee().getEvents_url());
                    forkee.setAssignees_url(forkEventEntity.getPayload().getForkee().getAssignees_url());
                    forkee.setBranches_url(forkEventEntity.getPayload().getForkee().getBranches_url());
                    forkee.setTags_url(forkEventEntity.getPayload().getForkee().getTags_url());
                    forkee.setBlobs_url(forkEventEntity.getPayload().getForkee().getBlobs_url());
                    forkee.setGit_tags_url(forkEventEntity.getPayload().getForkee().getGit_tags_url());
                    forkee.setGit_refs_url(forkEventEntity.getPayload().getForkee().getGit_refs_url());
                    forkee.setTrees_url(forkEventEntity.getPayload().getForkee().getTrees_url());
                    forkee.setStatuses_url(forkEventEntity.getPayload().getForkee().getStatuses_url());
                    forkee.setLanguages_url(forkEventEntity.getPayload().getForkee().getLanguages_url());
                    forkee.setStargazers_url(forkEventEntity.getPayload().getForkee().getStargazers_url());
                    forkee.setContributors_url(forkEventEntity.getPayload().getForkee().getContributors_url());
                    forkee.setSubscribers_url(forkEventEntity.getPayload().getForkee().getSubscribers_url());
                    forkee.setSubscription_url(forkEventEntity.getPayload().getForkee().getSubscription_url());
                    forkee.setCommits_url(forkEventEntity.getPayload().getForkee().getCommits_url());
                    forkee.setGit_commits_url(forkEventEntity.getPayload().getForkee().getGit_commits_url());
                    forkee.setComments_url(forkEventEntity.getPayload().getForkee().getComments_url());
                    forkee.setIssue_comment_url(forkEventEntity.getPayload().getForkee().getIssue_comment_url());
                    forkee.setContents_url(forkEventEntity.getPayload().getForkee().getContents_url());
                    forkee.setCompare_url(forkEventEntity.getPayload().getForkee().getCompare_url());
                    forkee.setMerges_url(forkEventEntity.getPayload().getForkee().getMerges_url());
                    forkee.setArchive_url(forkEventEntity.getPayload().getForkee().getArchive_url());
                    forkee.setDownloads_url(forkEventEntity.getPayload().getForkee().getDownloads_url());
                    forkee.setIssues_url(forkEventEntity.getPayload().getForkee().getIssues_url());
                    forkee.setPulls_url(forkEventEntity.getPayload().getForkee().getPulls_url());
                    forkee.setMilestones_url(forkEventEntity.getPayload().getForkee().getMilestones_url());
                    forkee.setNotifications_url(forkEventEntity.getPayload().getForkee().getNotifications_url());
                    forkee.setLabels_url(forkEventEntity.getPayload().getForkee().getLabels_url());
                    forkee.setReleases_url(forkEventEntity.getPayload().getForkee().getReleases_url());
                    forkee.setCreated_at(forkEventEntity.getPayload().getForkee().getCreated_at());
                    forkee.setUpdated_at(forkEventEntity.getPayload().getForkee().getUpdated_at());
                    forkee.setPushed_at(forkEventEntity.getPayload().getForkee().getPushed_at());
                    forkee.setGit_url(forkEventEntity.getPayload().getForkee().getGit_url());
                    forkee.setSsh_url(forkEventEntity.getPayload().getForkee().getSsh_url());
                    forkee.setClone_url(forkEventEntity.getPayload().getForkee().getClone_url());
                    forkee.setSvn_url(forkEventEntity.getPayload().getForkee().getSvn_url());
                    forkee.setHomepage(forkEventEntity.getPayload().getForkee().getHomepage());
                    forkee.setSize(forkEventEntity.getPayload().getForkee().getSize());
                    forkee.setStargazers_count(forkEventEntity.getPayload().getForkee().getStargazers_count());
                    forkee.setWatchers_count(forkEventEntity.getPayload().getForkee().getWatchers_count());
                    forkee.setLanguage(forkEventEntity.getPayload().getForkee().getLanguage());
                    forkee.setHas_issues(forkEventEntity.getPayload().getForkee().isHas_issues());
                    forkee.setHas_downloads(forkEventEntity.getPayload().getForkee().isHas_downloads());
                    forkee.setHas_wiki(forkEventEntity.getPayload().getForkee().isHas_wiki());
                    forkee.setHas_pages(forkEventEntity.getPayload().getForkee().isHas_pages());
                    forkee.setForks_count(forkEventEntity.getPayload().getForkee().getForks_count());
                    forkee.setMirror_url(forkEventEntity.getPayload().getForkee().getMirror_url());
                    forkee.setOpen_issues_count(forkEventEntity.getPayload().getForkee().getOpen_issues_count());
                    forkee.setForks(forkEventEntity.getPayload().getForkee().getForks());
                    forkee.setOpen_issues(forkEventEntity.getPayload().getForkee().getOpen_issues());
                    forkee.setWatchers(forkEventEntity.getPayload().getForkee().getWatchers());
                    forkee.setDefault_branch(forkEventEntity.getPayload().getForkee().getDefault_branch());
                    forkee.setPublicX(forkEventEntity.getPayload().getForkee().isPublicX());

                    payload.setForkee(forkee);
                }
                payload.setRepository(RepositoryMapper.transform(forkEventEntity.getPayload().getRepository()));
                payload.setSender(UserMapper.transform(forkEventEntity.getPayload().getSender()));
                forkEvent.setPayload(payload);
            }
        }
    }

    private static void transform4Member(Event event, EventEntity entity) {
        doBaseTransform(event, entity);

        if (event instanceof MemberEvent && entity instanceof MemberEventEntity) {
            MemberEvent memberEvent = (MemberEvent) event;
            MemberEventEntity memberEventEntity = (MemberEventEntity) entity;

            if (memberEventEntity.getPayload() != null) {
                MemberEvent.PayloadBean payload = new MemberEvent.PayloadBean();

                payload.setAction(memberEventEntity.getPayload().getAction());
                payload.setMember(UserMapper.transform(memberEventEntity.getPayload().getMember()));
                payload.setRepository(RepositoryMapper.transform(memberEventEntity.getPayload().getRepository()));
                payload.setSender(UserMapper.transform(memberEventEntity.getPayload().getSender()));

                memberEvent.setPayload(payload);
            }
        }
    }

    private static void transform4Watch(Event event, EventEntity entity) {
        doBaseTransform(event, entity);

        if (event instanceof WatchEvent && entity instanceof WatchEventEntity) {
            WatchEvent watchEvent = (WatchEvent) event;
            WatchEventEntity watchEventEntity = (WatchEventEntity) entity;

            if (watchEventEntity.getPayload() != null) {
                WatchEvent.PayloadBean payload = new WatchEvent.PayloadBean();

                payload.setAction(watchEventEntity.getPayload().getAction());
                payload.setRepository(RepositoryMapper.transform(watchEventEntity.getPayload().getRepository()));
                payload.setSender(UserMapper.transform(watchEventEntity.getPayload().getSender()));

                watchEvent.setPayload(payload);
            }
        }
    }
}
