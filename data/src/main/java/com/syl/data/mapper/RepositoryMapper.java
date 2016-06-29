package com.syl.data.mapper;

import com.syl.data.model.RepositoryEntity;
import com.syl.domain.model.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @see Repository
 * @see RepositoryEntity
 * Created by Shen YunLong on 2016/06/24.
 */
public class RepositoryMapper {

    public static List<Repository> transform(List<RepositoryEntity> entityList) {
        List<Repository> list = new ArrayList<>();

        for (RepositoryEntity entity : entityList) {
            Repository repo = transform(entity);
            if (repo != null) {
                list.add(repo);
            }
        }

        return list;
    }

    public static Repository transform(RepositoryEntity entity) {
        if (entity == null) {
            return null;
        }

        Repository repo = new Repository();

        repo.setId(entity.getId());
        repo.setOwner(UserMapper.transform(entity.getOwner()));
        repo.setName(entity.getName());
        repo.setFull_name(entity.getFull_name());
        repo.setDescription(entity.getDescription());
        repo.setPrivateX(entity.isPrivateX());
        repo.setFork(entity.isFork());
        repo.setUrl(entity.getUrl());
        repo.setHtml_url(entity.getHtml_url());
        repo.setArchive_url(entity.getArchive_url());
        repo.setAssignees_url(entity.getAssignees_url());
        repo.setBlobs_url(entity.getBlobs_url());
        repo.setBranches_url(entity.getBranches_url());
        repo.setClone_url(entity.getClone_url());
        repo.setCollaborators_url(entity.getCollaborators_url());
        repo.setComments_url(entity.getComments_url());
        repo.setCommits_url(entity.getCommits_url());
        repo.setCompare_url(entity.getCompare_url());
        repo.setContents_url(entity.getContents_url());
        repo.setContributors_url(entity.getContributors_url());
        repo.setDeployments_url(entity.getDeployments_url());
        repo.setDownloads_url(entity.getDownloads_url());
        repo.setEvents_url(entity.getEvents_url());
        repo.setForks_url(entity.getForks_url());
        repo.setGit_commits_url(entity.getGit_commits_url());
        repo.setGit_refs_url(entity.getGit_refs_url());
        repo.setGit_tags_url(entity.getGit_tags_url());
        repo.setGit_url(entity.getGit_url());
        repo.setHooks_url(entity.getHooks_url());
        repo.setIssue_comment_url(entity.getIssue_comment_url());
        repo.setIssue_events_url(entity.getIssue_events_url());
        repo.setIssues_url(entity.getIssues_url());
        repo.setKeys_url(entity.getKeys_url());
        repo.setLabels_url(entity.getLabels_url());
        repo.setLanguages_url(entity.getLanguages_url());
        repo.setMerges_url(entity.getMerges_url());
        repo.setMilestones_url(entity.getMilestones_url());
        repo.setMirror_url(entity.getMirror_url());
        repo.setNotifications_url(entity.getNotifications_url());
        repo.setPulls_url(entity.getPulls_url());
        repo.setReleases_url(entity.getReleases_url());
        repo.setSsh_url(entity.getSsh_url());
        repo.setStargazers_url(entity.getStargazers_url());
        repo.setStatuses_url(entity.getStatuses_url());
        repo.setSubscribers_url(entity.getSubscribers_url());
        repo.setSubscription_url(entity.getSubscription_url());
        repo.setSvn_url(entity.getSvn_url());
        repo.setTags_url(entity.getTags_url());
        repo.setTeams_url(entity.getTeams_url());
        repo.setTrees_url(entity.getTrees_url());
        repo.setHomepage(entity.getHomepage());
        repo.setLanguage(entity.getLanguage());
        repo.setForks_count(entity.getForks_count());
        repo.setStargazers_count(entity.getStargazers_count());
        repo.setWatchers_count(entity.getWatchers_count());
        repo.setSize(entity.getSize());
        repo.setDefault_branch(entity.getDefault_branch());
        repo.setOpen_issues_count(entity.getOpen_issues_count());
        repo.setHas_issues(entity.isHas_issues());
        repo.setHas_wiki(entity.isHas_wiki());
        repo.setHas_pages(entity.isHas_pages());
        repo.setHas_downloads(entity.isHas_downloads());
        repo.setPushed_at(entity.getPushed_at());
        repo.setCreated_at(entity.getCreated_at());
        repo.setUpdated_at(entity.getUpdated_at());

        if (entity.getPermissions() != null) {
            Repository.PermissionsBean permission = new Repository.PermissionsBean();
            permission.setAdmin(entity.getPermissions().isAdmin());
            permission.setPush(entity.getPermissions().isPush());
            permission.setPull(entity.getPermissions().isPull());
            repo.setPermissions(permission);
        }

        return repo;
    }
}
