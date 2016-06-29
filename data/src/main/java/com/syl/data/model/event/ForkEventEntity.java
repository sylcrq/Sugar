package com.syl.data.model.event;

import com.google.gson.annotations.SerializedName;
import com.syl.data.model.EventEntity;
import com.syl.data.model.RepositoryEntity;
import com.syl.data.model.UserEntity;

/**
 * Model ForkEvent
 * <p/>
 * Created by Shen YunLong on 2016/05/12.
 */
public class ForkEventEntity extends EventEntity {

    public static final String TYPE = "ForkEvent";

    private PayloadBean payload;

    public PayloadBean getPayload() {
        return payload;
    }

    public void setPayload(PayloadBean payload) {
        this.payload = payload;
    }

    public static class PayloadBean {

        private ForkeeBean forkee;
        private RepositoryEntity repository;
        private UserEntity sender;

        public ForkeeBean getForkee() {
            return forkee;
        }

        public void setForkee(ForkeeBean forkee) {
            this.forkee = forkee;
        }

        public RepositoryEntity getRepository() {
            return repository;
        }

        public void setRepository(RepositoryEntity repository) {
            this.repository = repository;
        }

        public UserEntity getSender() {
            return sender;
        }

        public void setSender(UserEntity sender) {
            this.sender = sender;
        }

        public static class ForkeeBean {
            private int id;
            private String name;
            private String full_name;
            private UserEntity owner;
            @SerializedName("private")
            private boolean privateX;
            private String html_url;
            private String description;
            private boolean fork;
            private String url;
            private String forks_url;
            private String keys_url;
            private String collaborators_url;
            private String teams_url;
            private String hooks_url;
            private String issue_events_url;
            private String events_url;
            private String assignees_url;
            private String branches_url;
            private String tags_url;
            private String blobs_url;
            private String git_tags_url;
            private String git_refs_url;
            private String trees_url;
            private String statuses_url;
            private String languages_url;
            private String stargazers_url;
            private String contributors_url;
            private String subscribers_url;
            private String subscription_url;
            private String commits_url;
            private String git_commits_url;
            private String comments_url;
            private String issue_comment_url;
            private String contents_url;
            private String compare_url;
            private String merges_url;
            private String archive_url;
            private String downloads_url;
            private String issues_url;
            private String pulls_url;
            private String milestones_url;
            private String notifications_url;
            private String labels_url;
            private String releases_url;
            private String created_at;
            private String updated_at;
            private String pushed_at;
            private String git_url;
            private String ssh_url;
            private String clone_url;
            private String svn_url;
            private String homepage;
            private int size;
            private int stargazers_count;
            private int watchers_count;
            private String language;
            private boolean has_issues;
            private boolean has_downloads;
            private boolean has_wiki;
            private boolean has_pages;
            private int forks_count;
            private String mirror_url;
            private int open_issues_count;
            private int forks;
            private int open_issues;
            private int watchers;
            private String default_branch;
            @SerializedName("public")
            private boolean publicX;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getFull_name() {
                return full_name;
            }

            public void setFull_name(String full_name) {
                this.full_name = full_name;
            }

            public boolean isPrivateX() {
                return privateX;
            }

            public void setPrivateX(boolean privateX) {
                this.privateX = privateX;
            }

            public String getHtml_url() {
                return html_url;
            }

            public void setHtml_url(String html_url) {
                this.html_url = html_url;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public boolean isFork() {
                return fork;
            }

            public void setFork(boolean fork) {
                this.fork = fork;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getForks_url() {
                return forks_url;
            }

            public void setForks_url(String forks_url) {
                this.forks_url = forks_url;
            }

            public String getKeys_url() {
                return keys_url;
            }

            public void setKeys_url(String keys_url) {
                this.keys_url = keys_url;
            }

            public String getCollaborators_url() {
                return collaborators_url;
            }

            public void setCollaborators_url(String collaborators_url) {
                this.collaborators_url = collaborators_url;
            }

            public String getTeams_url() {
                return teams_url;
            }

            public void setTeams_url(String teams_url) {
                this.teams_url = teams_url;
            }

            public String getHooks_url() {
                return hooks_url;
            }

            public void setHooks_url(String hooks_url) {
                this.hooks_url = hooks_url;
            }

            public String getIssue_events_url() {
                return issue_events_url;
            }

            public void setIssue_events_url(String issue_events_url) {
                this.issue_events_url = issue_events_url;
            }

            public String getEvents_url() {
                return events_url;
            }

            public void setEvents_url(String events_url) {
                this.events_url = events_url;
            }

            public String getAssignees_url() {
                return assignees_url;
            }

            public void setAssignees_url(String assignees_url) {
                this.assignees_url = assignees_url;
            }

            public String getBranches_url() {
                return branches_url;
            }

            public void setBranches_url(String branches_url) {
                this.branches_url = branches_url;
            }

            public String getTags_url() {
                return tags_url;
            }

            public void setTags_url(String tags_url) {
                this.tags_url = tags_url;
            }

            public String getBlobs_url() {
                return blobs_url;
            }

            public void setBlobs_url(String blobs_url) {
                this.blobs_url = blobs_url;
            }

            public String getGit_tags_url() {
                return git_tags_url;
            }

            public void setGit_tags_url(String git_tags_url) {
                this.git_tags_url = git_tags_url;
            }

            public String getGit_refs_url() {
                return git_refs_url;
            }

            public void setGit_refs_url(String git_refs_url) {
                this.git_refs_url = git_refs_url;
            }

            public String getTrees_url() {
                return trees_url;
            }

            public void setTrees_url(String trees_url) {
                this.trees_url = trees_url;
            }

            public String getStatuses_url() {
                return statuses_url;
            }

            public void setStatuses_url(String statuses_url) {
                this.statuses_url = statuses_url;
            }

            public String getLanguages_url() {
                return languages_url;
            }

            public void setLanguages_url(String languages_url) {
                this.languages_url = languages_url;
            }

            public String getStargazers_url() {
                return stargazers_url;
            }

            public void setStargazers_url(String stargazers_url) {
                this.stargazers_url = stargazers_url;
            }

            public String getContributors_url() {
                return contributors_url;
            }

            public void setContributors_url(String contributors_url) {
                this.contributors_url = contributors_url;
            }

            public String getSubscribers_url() {
                return subscribers_url;
            }

            public void setSubscribers_url(String subscribers_url) {
                this.subscribers_url = subscribers_url;
            }

            public String getSubscription_url() {
                return subscription_url;
            }

            public void setSubscription_url(String subscription_url) {
                this.subscription_url = subscription_url;
            }

            public String getCommits_url() {
                return commits_url;
            }

            public void setCommits_url(String commits_url) {
                this.commits_url = commits_url;
            }

            public String getGit_commits_url() {
                return git_commits_url;
            }

            public void setGit_commits_url(String git_commits_url) {
                this.git_commits_url = git_commits_url;
            }

            public String getComments_url() {
                return comments_url;
            }

            public void setComments_url(String comments_url) {
                this.comments_url = comments_url;
            }

            public String getIssue_comment_url() {
                return issue_comment_url;
            }

            public void setIssue_comment_url(String issue_comment_url) {
                this.issue_comment_url = issue_comment_url;
            }

            public String getContents_url() {
                return contents_url;
            }

            public void setContents_url(String contents_url) {
                this.contents_url = contents_url;
            }

            public String getCompare_url() {
                return compare_url;
            }

            public void setCompare_url(String compare_url) {
                this.compare_url = compare_url;
            }

            public String getMerges_url() {
                return merges_url;
            }

            public void setMerges_url(String merges_url) {
                this.merges_url = merges_url;
            }

            public String getArchive_url() {
                return archive_url;
            }

            public void setArchive_url(String archive_url) {
                this.archive_url = archive_url;
            }

            public String getDownloads_url() {
                return downloads_url;
            }

            public void setDownloads_url(String downloads_url) {
                this.downloads_url = downloads_url;
            }

            public String getIssues_url() {
                return issues_url;
            }

            public void setIssues_url(String issues_url) {
                this.issues_url = issues_url;
            }

            public String getPulls_url() {
                return pulls_url;
            }

            public void setPulls_url(String pulls_url) {
                this.pulls_url = pulls_url;
            }

            public String getMilestones_url() {
                return milestones_url;
            }

            public void setMilestones_url(String milestones_url) {
                this.milestones_url = milestones_url;
            }

            public String getNotifications_url() {
                return notifications_url;
            }

            public void setNotifications_url(String notifications_url) {
                this.notifications_url = notifications_url;
            }

            public String getLabels_url() {
                return labels_url;
            }

            public void setLabels_url(String labels_url) {
                this.labels_url = labels_url;
            }

            public String getReleases_url() {
                return releases_url;
            }

            public void setReleases_url(String releases_url) {
                this.releases_url = releases_url;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public String getPushed_at() {
                return pushed_at;
            }

            public void setPushed_at(String pushed_at) {
                this.pushed_at = pushed_at;
            }

            public String getGit_url() {
                return git_url;
            }

            public void setGit_url(String git_url) {
                this.git_url = git_url;
            }

            public String getSsh_url() {
                return ssh_url;
            }

            public void setSsh_url(String ssh_url) {
                this.ssh_url = ssh_url;
            }

            public String getClone_url() {
                return clone_url;
            }

            public void setClone_url(String clone_url) {
                this.clone_url = clone_url;
            }

            public String getSvn_url() {
                return svn_url;
            }

            public void setSvn_url(String svn_url) {
                this.svn_url = svn_url;
            }

            public String getHomepage() {
                return homepage;
            }

            public void setHomepage(String homepage) {
                this.homepage = homepage;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getStargazers_count() {
                return stargazers_count;
            }

            public void setStargazers_count(int stargazers_count) {
                this.stargazers_count = stargazers_count;
            }

            public int getWatchers_count() {
                return watchers_count;
            }

            public void setWatchers_count(int watchers_count) {
                this.watchers_count = watchers_count;
            }

            public String getLanguage() {
                return language;
            }

            public void setLanguage(String language) {
                this.language = language;
            }

            public boolean isHas_issues() {
                return has_issues;
            }

            public void setHas_issues(boolean has_issues) {
                this.has_issues = has_issues;
            }

            public boolean isHas_downloads() {
                return has_downloads;
            }

            public void setHas_downloads(boolean has_downloads) {
                this.has_downloads = has_downloads;
            }

            public boolean isHas_wiki() {
                return has_wiki;
            }

            public void setHas_wiki(boolean has_wiki) {
                this.has_wiki = has_wiki;
            }

            public boolean isHas_pages() {
                return has_pages;
            }

            public void setHas_pages(boolean has_pages) {
                this.has_pages = has_pages;
            }

            public int getForks_count() {
                return forks_count;
            }

            public void setForks_count(int forks_count) {
                this.forks_count = forks_count;
            }

            public String getMirror_url() {
                return mirror_url;
            }

            public void setMirror_url(String mirror_url) {
                this.mirror_url = mirror_url;
            }

            public int getOpen_issues_count() {
                return open_issues_count;
            }

            public void setOpen_issues_count(int open_issues_count) {
                this.open_issues_count = open_issues_count;
            }

            public int getForks() {
                return forks;
            }

            public void setForks(int forks) {
                this.forks = forks;
            }

            public int getOpen_issues() {
                return open_issues;
            }

            public void setOpen_issues(int open_issues) {
                this.open_issues = open_issues;
            }

            public int getWatchers() {
                return watchers;
            }

            public void setWatchers(int watchers) {
                this.watchers = watchers;
            }

            public String getDefault_branch() {
                return default_branch;
            }

            public void setDefault_branch(String default_branch) {
                this.default_branch = default_branch;
            }

            public boolean isPublicX() {
                return publicX;
            }

            public void setPublicX(boolean publicX) {
                this.publicX = publicX;
            }

            public UserEntity getOwner() {
                return owner;
            }

            public void setOwner(UserEntity owner) {
                this.owner = owner;
            }
        }
    }

//    @Override
//    public void transform(EventEntity entity, Event event) {
//        super.transform(entity, event);
//
//        if (entity instanceof ForkEventEntity && event instanceof ForkEvent) {
//            if (((ForkEventEntity) entity).getPayload() != null) {
//                ForkEvent.PayloadBean payloadBean = new ForkEvent.PayloadBean();
//
//                if (((ForkEventEntity) entity).getPayload().getForkee() != null) {
//                    ForkEvent.PayloadBean.ForkeeBean forkeeBean = new ForkEvent.PayloadBean.ForkeeBean();
//                    forkeeBean.setId(((ForkEventEntity) entity).getPayload().getForkee().getId());
//                    forkeeBean.setName(((ForkEventEntity) entity).getPayload().getForkee().getName());
//                    forkeeBean.setFull_name(((ForkEventEntity) entity).getPayload().getForkee().getFull_name());
//                    forkeeBean.setPrivateX(((ForkEventEntity) entity).getPayload().getForkee().isPrivateX());
//                    forkeeBean.setHtml_url(((ForkEventEntity) entity).getPayload().getForkee().getHtml_url());
//                    forkeeBean.setDescription(((ForkEventEntity) entity).getPayload().getForkee().getDescription());
//                    forkeeBean.setFork(((ForkEventEntity) entity).getPayload().getForkee().isFork());
//                    forkeeBean.setUrl(((ForkEventEntity) entity).getPayload().getForkee().getUrl());
//                    forkeeBean.setForks_url(((ForkEventEntity) entity).getPayload().getForkee().getForks_url());
//                    forkeeBean.setKeys_url(((ForkEventEntity) entity).getPayload().getForkee().getKeys_url());
//                    forkeeBean.setCollaborators_url(((ForkEventEntity) entity).getPayload().getForkee().getCollaborators_url());
//                    forkeeBean.setTeams_url(((ForkEventEntity) entity).getPayload().getForkee().getTeams_url());
//                    forkeeBean.setHooks_url(((ForkEventEntity) entity).getPayload().getForkee().getHooks_url());
//                    forkeeBean.setIssue_events_url(((ForkEventEntity) entity).getPayload().getForkee().getIssue_events_url());
//                    forkeeBean.setEvents_url(((ForkEventEntity) entity).getPayload().getForkee().getEvents_url());
//                    forkeeBean.setAssignees_url(((ForkEventEntity) entity).getPayload().getForkee().getAssignees_url());
//                    forkeeBean.setBranches_url(((ForkEventEntity) entity).getPayload().getForkee().getBranches_url());
//                    forkeeBean.setTags_url(((ForkEventEntity) entity).getPayload().getForkee().getTags_url());
//                    forkeeBean.setBlobs_url(((ForkEventEntity) entity).getPayload().getForkee().getBlobs_url());
//                    forkeeBean.setGit_tags_url(((ForkEventEntity) entity).getPayload().getForkee().getGit_tags_url());
//                    forkeeBean.setGit_refs_url(((ForkEventEntity) entity).getPayload().getForkee().getGit_refs_url());
//                    forkeeBean.setTrees_url(((ForkEventEntity) entity).getPayload().getForkee().getTrees_url());
//                    forkeeBean.setStatuses_url(((ForkEventEntity) entity).getPayload().getForkee().getStatuses_url());
//                    forkeeBean.setLanguages_url(((ForkEventEntity) entity).getPayload().getForkee().getLanguages_url());
//                    forkeeBean.setStargazers_url(((ForkEventEntity) entity).getPayload().getForkee().getStargazers_url());
//                    forkeeBean.setContributors_url(((ForkEventEntity) entity).getPayload().getForkee().getContributors_url());
//                    forkeeBean.setSubscribers_url(((ForkEventEntity) entity).getPayload().getForkee().getSubscribers_url());
//                    forkeeBean.setSubscription_url(((ForkEventEntity) entity).getPayload().getForkee().getSubscription_url());
//                    forkeeBean.setCommits_url(((ForkEventEntity) entity).getPayload().getForkee().getCommits_url());
//                    forkeeBean.setGit_commits_url(((ForkEventEntity) entity).getPayload().getForkee().getGit_commits_url());
//                    forkeeBean.setComments_url(((ForkEventEntity) entity).getPayload().getForkee().getComments_url());
//                    forkeeBean.setIssue_comment_url(((ForkEventEntity) entity).getPayload().getForkee().getIssue_comment_url());
//                    forkeeBean.setContents_url(((ForkEventEntity) entity).getPayload().getForkee().getContents_url());
//                    forkeeBean.setCompare_url(((ForkEventEntity) entity).getPayload().getForkee().getCompare_url());
//                    forkeeBean.setMerges_url(((ForkEventEntity) entity).getPayload().getForkee().getMerges_url());
//                    forkeeBean.setArchive_url(((ForkEventEntity) entity).getPayload().getForkee().getArchive_url());
//                    forkeeBean.setDownloads_url(((ForkEventEntity) entity).getPayload().getForkee().getDownloads_url());
//                    forkeeBean.setIssues_url(((ForkEventEntity) entity).getPayload().getForkee().getIssues_url());
//                    forkeeBean.setPulls_url(((ForkEventEntity) entity).getPayload().getForkee().getPulls_url());
//                    forkeeBean.setMilestones_url(((ForkEventEntity) entity).getPayload().getForkee().getMilestones_url());
//                    forkeeBean.setNotifications_url(((ForkEventEntity) entity).getPayload().getForkee().getNotifications_url());
//                    forkeeBean.setLabels_url(((ForkEventEntity) entity).getPayload().getForkee().getLabels_url());
//                    forkeeBean.setReleases_url(((ForkEventEntity) entity).getPayload().getForkee().getReleases_url());
//                    forkeeBean.setDeployments_url(((ForkEventEntity) entity).getPayload().getForkee().getDeployments_url());
//                    forkeeBean.setCreated_at(((ForkEventEntity) entity).getPayload().getForkee().getCreated_at());
//                    forkeeBean.setUpdated_at(((ForkEventEntity) entity).getPayload().getForkee().getUpdated_at());
//                    forkeeBean.setPushed_at(((ForkEventEntity) entity).getPayload().getForkee().getPushed_at());
//                    forkeeBean.setGit_url(((ForkEventEntity) entity).getPayload().getForkee().getGit_url());
//                    forkeeBean.setSsh_url(((ForkEventEntity) entity).getPayload().getForkee().getSsh_url());
//                    forkeeBean.setClone_url(((ForkEventEntity) entity).getPayload().getForkee().getClone_url());
//                    forkeeBean.setSvn_url(((ForkEventEntity) entity).getPayload().getForkee().getSvn_url());
//                    forkeeBean.setHomepage(((ForkEventEntity) entity).getPayload().getForkee().getHomepage());
//                    forkeeBean.setSize(((ForkEventEntity) entity).getPayload().getForkee().getSize());
//                    forkeeBean.setStargazers_count(((ForkEventEntity) entity).getPayload().getForkee().getStargazers_count());
//                    forkeeBean.setWatchers_count(((ForkEventEntity) entity).getPayload().getForkee().getWatchers_count());
//                    forkeeBean.setLanguage(((ForkEventEntity) entity).getPayload().getForkee().getLanguage());
//                    forkeeBean.setHas_issues(((ForkEventEntity) entity).getPayload().getForkee().isHas_issues());
//                    forkeeBean.setHas_downloads(((ForkEventEntity) entity).getPayload().getForkee().isHas_downloads());
//                    forkeeBean.setHas_wiki(((ForkEventEntity) entity).getPayload().getForkee().isHas_wiki());
//                    forkeeBean.setHas_pages(((ForkEventEntity) entity).getPayload().getForkee().isHas_pages());
//                    forkeeBean.setForks_count(((ForkEventEntity) entity).getPayload().getForkee().getForks_count());
//                    forkeeBean.setMirror_url(((ForkEventEntity) entity).getPayload().getForkee().getMirror_url());
//                    forkeeBean.setOpen_issues_count(((ForkEventEntity) entity).getPayload().getForkee().getOpen_issues_count());
//                    forkeeBean.setForks(((ForkEventEntity) entity).getPayload().getForkee().getForks());
//                    forkeeBean.setOpen_issues(((ForkEventEntity) entity).getPayload().getForkee().getOpen_issues());
//                    forkeeBean.setWatchers(((ForkEventEntity) entity).getPayload().getForkee().getWatchers());
//                    forkeeBean.setDefault_branch(((ForkEventEntity) entity).getPayload().getForkee().getDefault_branch());
//                    forkeeBean.setPublicX(((ForkEventEntity) entity).getPayload().getForkee().isPublicX());
//
//                    if (((ForkEventEntity) entity).getPayload().getForkee().getOwner() != null) {
//                        ForkEvent.PayloadBean.ForkeeBean.OwnerBean ownerBean = new ForkEvent.PayloadBean.ForkeeBean.OwnerBean();
//                        ownerBean.setId(((ForkEventEntity) entity).getPayload().getForkee().getOwner().getId());
//                        ownerBean.setLogin(((ForkEventEntity) entity).getPayload().getForkee().getOwner().getLogin());
//                        ownerBean.setAvatar_url(((ForkEventEntity) entity).getPayload().getForkee().getOwner().getAvatar_url());
//                        ownerBean.setGravatar_id(((ForkEventEntity) entity).getPayload().getForkee().getOwner().getGravatar_id());
//                        ownerBean.setUrl(((ForkEventEntity) entity).getPayload().getForkee().getOwner().getUrl());
//                        ownerBean.setHtml_url(((ForkEventEntity) entity).getPayload().getForkee().getOwner().getHtml_url());
//                        ownerBean.setFollowers_url(((ForkEventEntity) entity).getPayload().getForkee().getOwner().getFollowers_url());
//                        ownerBean.setFollowing_url(((ForkEventEntity) entity).getPayload().getForkee().getOwner().getFollowing_url());
//                        ownerBean.setGists_url(((ForkEventEntity) entity).getPayload().getForkee().getOwner().getGists_url());
//                        ownerBean.setStarred_url(((ForkEventEntity) entity).getPayload().getForkee().getOwner().getStarred_url());
//                        ownerBean.setSubscriptions_url(((ForkEventEntity) entity).getPayload().getForkee().getOwner().getSubscriptions_url());
//                        ownerBean.setOrganizations_url(((ForkEventEntity) entity).getPayload().getForkee().getOwner().getOrganizations_url());
//                        ownerBean.setRepos_url(((ForkEventEntity) entity).getPayload().getForkee().getOwner().getRepos_url());
//                        ownerBean.setEvents_url(((ForkEventEntity) entity).getPayload().getForkee().getOwner().getEvents_url());
//                        ownerBean.setReceived_events_url(((ForkEventEntity) entity).getPayload().getForkee().getOwner().getReceived_events_url());
//                        ownerBean.setType(((ForkEventEntity) entity).getPayload().getForkee().getOwner().getType());
//                        ownerBean.setSite_admin(((ForkEventEntity) entity).getPayload().getForkee().getOwner().isSite_admin());
//                        forkeeBean.setOwner(ownerBean);
//                    }
//                    payloadBean.setForkee(forkeeBean);
//                }
//                ((ForkEvent) event).setPayload(payloadBean);
//            }
//        }
//    }
}
