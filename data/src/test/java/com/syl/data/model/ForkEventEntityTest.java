package com.syl.data.model;

import com.syl.basecore.json.SugarJson;
import com.syl.domain.model.ForkEvent;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * 单元测试代码
 * <p/>
 * Created by Shen YunLong on 2016/05/13.
 */
public class ForkEventEntityTest {

    private static final String FAKE_FORK_EVENT_JSON = "{\n" +
            "    \"id\": \"3993508642\",\n" +
            "    \"type\": \"ForkEvent\",\n" +
            "    \"actor\": {\n" +
            "      \"id\": 3098704,\n" +
            "      \"login\": \"Piasy\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/users/Piasy\",\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/3098704?\"\n" +
            "    },\n" +
            "    \"repo\": {\n" +
            "      \"id\": 43598554,\n" +
            "      \"name\": \"OkBuilds/OkBuck\",\n" +
            "      \"url\": \"https://api.github.com/repos/OkBuilds/OkBuck\"\n" +
            "    },\n" +
            "    \"payload\": {\n" +
            "      \"forkee\": {\n" +
            "        \"id\": 58443990,\n" +
            "        \"name\": \"OkBuck\",\n" +
            "        \"full_name\": \"Piasy/OkBuck\",\n" +
            "        \"owner\": {\n" +
            "          \"login\": \"Piasy\",\n" +
            "          \"id\": 3098704,\n" +
            "          \"avatar_url\": \"https://avatars.githubusercontent.com/u/3098704?v=3\",\n" +
            "          \"gravatar_id\": \"\",\n" +
            "          \"url\": \"https://api.github.com/users/Piasy\",\n" +
            "          \"html_url\": \"https://github.com/Piasy\",\n" +
            "          \"followers_url\": \"https://api.github.com/users/Piasy/followers\",\n" +
            "          \"following_url\": \"https://api.github.com/users/Piasy/following{/other_user}\",\n" +
            "          \"gists_url\": \"https://api.github.com/users/Piasy/gists{/gist_id}\",\n" +
            "          \"starred_url\": \"https://api.github.com/users/Piasy/starred{/owner}{/repo}\",\n" +
            "          \"subscriptions_url\": \"https://api.github.com/users/Piasy/subscriptions\",\n" +
            "          \"organizations_url\": \"https://api.github.com/users/Piasy/orgs\",\n" +
            "          \"repos_url\": \"https://api.github.com/users/Piasy/repos\",\n" +
            "          \"events_url\": \"https://api.github.com/users/Piasy/events{/privacy}\",\n" +
            "          \"received_events_url\": \"https://api.github.com/users/Piasy/received_events\",\n" +
            "          \"type\": \"User\",\n" +
            "          \"site_admin\": false\n" +
            "        },\n" +
            "        \"private\": false,\n" +
            "        \"html_url\": \"https://github.com/Piasy/OkBuck\",\n" +
            "        \"description\": \"OkBuck is a gradle plugin, aiming to help developers utilize the super fast build system: BUCK, based on the existing project with Android Studio + gradle, and keep both build systems work, with few lines configuration.\",\n" +
            "        \"fork\": true,\n" +
            "        \"url\": \"https://api.github.com/repos/Piasy/OkBuck\",\n" +
            "        \"forks_url\": \"https://api.github.com/repos/Piasy/OkBuck/forks\",\n" +
            "        \"keys_url\": \"https://api.github.com/repos/Piasy/OkBuck/keys{/key_id}\",\n" +
            "        \"collaborators_url\": \"https://api.github.com/repos/Piasy/OkBuck/collaborators{/collaborator}\",\n" +
            "        \"teams_url\": \"https://api.github.com/repos/Piasy/OkBuck/teams\",\n" +
            "        \"hooks_url\": \"https://api.github.com/repos/Piasy/OkBuck/hooks\",\n" +
            "        \"issue_events_url\": \"https://api.github.com/repos/Piasy/OkBuck/issues/events{/number}\",\n" +
            "        \"events_url\": \"https://api.github.com/repos/Piasy/OkBuck/events\",\n" +
            "        \"assignees_url\": \"https://api.github.com/repos/Piasy/OkBuck/assignees{/user}\",\n" +
            "        \"branches_url\": \"https://api.github.com/repos/Piasy/OkBuck/branches{/branch}\",\n" +
            "        \"tags_url\": \"https://api.github.com/repos/Piasy/OkBuck/tags\",\n" +
            "        \"blobs_url\": \"https://api.github.com/repos/Piasy/OkBuck/git/blobs{/sha}\",\n" +
            "        \"git_tags_url\": \"https://api.github.com/repos/Piasy/OkBuck/git/tags{/sha}\",\n" +
            "        \"git_refs_url\": \"https://api.github.com/repos/Piasy/OkBuck/git/refs{/sha}\",\n" +
            "        \"trees_url\": \"https://api.github.com/repos/Piasy/OkBuck/git/trees{/sha}\",\n" +
            "        \"statuses_url\": \"https://api.github.com/repos/Piasy/OkBuck/statuses/{sha}\",\n" +
            "        \"languages_url\": \"https://api.github.com/repos/Piasy/OkBuck/languages\",\n" +
            "        \"stargazers_url\": \"https://api.github.com/repos/Piasy/OkBuck/stargazers\",\n" +
            "        \"contributors_url\": \"https://api.github.com/repos/Piasy/OkBuck/contributors\",\n" +
            "        \"subscribers_url\": \"https://api.github.com/repos/Piasy/OkBuck/subscribers\",\n" +
            "        \"subscription_url\": \"https://api.github.com/repos/Piasy/OkBuck/subscription\",\n" +
            "        \"commits_url\": \"https://api.github.com/repos/Piasy/OkBuck/commits{/sha}\",\n" +
            "        \"git_commits_url\": \"https://api.github.com/repos/Piasy/OkBuck/git/commits{/sha}\",\n" +
            "        \"comments_url\": \"https://api.github.com/repos/Piasy/OkBuck/comments{/number}\",\n" +
            "        \"issue_comment_url\": \"https://api.github.com/repos/Piasy/OkBuck/issues/comments{/number}\",\n" +
            "        \"contents_url\": \"https://api.github.com/repos/Piasy/OkBuck/contents/{+path}\",\n" +
            "        \"compare_url\": \"https://api.github.com/repos/Piasy/OkBuck/compare/{base}...{head}\",\n" +
            "        \"merges_url\": \"https://api.github.com/repos/Piasy/OkBuck/merges\",\n" +
            "        \"archive_url\": \"https://api.github.com/repos/Piasy/OkBuck/{archive_format}{/ref}\",\n" +
            "        \"downloads_url\": \"https://api.github.com/repos/Piasy/OkBuck/downloads\",\n" +
            "        \"issues_url\": \"https://api.github.com/repos/Piasy/OkBuck/issues{/number}\",\n" +
            "        \"pulls_url\": \"https://api.github.com/repos/Piasy/OkBuck/pulls{/number}\",\n" +
            "        \"milestones_url\": \"https://api.github.com/repos/Piasy/OkBuck/milestones{/number}\",\n" +
            "        \"notifications_url\": \"https://api.github.com/repos/Piasy/OkBuck/notifications{?since,all,participating}\",\n" +
            "        \"labels_url\": \"https://api.github.com/repos/Piasy/OkBuck/labels{/name}\",\n" +
            "        \"releases_url\": \"https://api.github.com/repos/Piasy/OkBuck/releases{/id}\",\n" +
            "        \"deployments_url\": \"https://api.github.com/repos/Piasy/OkBuck/deployments\",\n" +
            "        \"created_at\": \"2016-05-10T08:39:14Z\",\n" +
            "        \"updated_at\": \"2016-05-09T18:54:24Z\",\n" +
            "        \"pushed_at\": \"2016-05-10T08:38:36Z\",\n" +
            "        \"git_url\": \"git://github.com/Piasy/OkBuck.git\",\n" +
            "        \"ssh_url\": \"git@github.com:Piasy/OkBuck.git\",\n" +
            "        \"clone_url\": \"https://github.com/Piasy/OkBuck.git\",\n" +
            "        \"svn_url\": \"https://github.com/Piasy/OkBuck\",\n" +
            "        \"homepage\": \"http://blog.piasy.com/OkBuck/\",\n" +
            "        \"size\": 7672,\n" +
            "        \"stargazers_count\": 0,\n" +
            "        \"watchers_count\": 0,\n" +
            "        \"language\": null,\n" +
            "        \"has_issues\": false,\n" +
            "        \"has_downloads\": true,\n" +
            "        \"has_wiki\": true,\n" +
            "        \"has_pages\": false,\n" +
            "        \"forks_count\": 0,\n" +
            "        \"mirror_url\": null,\n" +
            "        \"open_issues_count\": 0,\n" +
            "        \"forks\": 0,\n" +
            "        \"open_issues\": 0,\n" +
            "        \"watchers\": 0,\n" +
            "        \"default_branch\": \"master\",\n" +
            "        \"public\": true\n" +
            "      }\n" +
            "    },\n" +
            "    \"public\": true,\n" +
            "    \"created_at\": \"2016-05-10T08:39:15Z\",\n" +
            "    \"org\": {\n" +
            "      \"id\": 19268334,\n" +
            "      \"login\": \"OkBuilds\",\n" +
            "      \"gravatar_id\": \"\",\n" +
            "      \"url\": \"https://api.github.com/orgs/OkBuilds\",\n" +
            "      \"avatar_url\": \"https://avatars.githubusercontent.com/u/19268334?\"\n" +
            "    }\n" +
            "  }";

    @Before
    public void setUp() {
    }

    @Test
    public void testConstructHappyCase() {
        ForkEventEntity entity = SugarJson.fromJson(FAKE_FORK_EVENT_JSON, ForkEventEntity.class);

        assertThat(entity.getId(), is(equalTo("3993508642")));
        assertThat(entity.getType(), is(equalTo("ForkEvent")));
        assertThat(entity.getActor().getId(), is(3098704));
        assertThat(entity.getActor().getLogin(), is(equalTo("Piasy")));
        assertThat(entity.getRepo().getId(), is(43598554));
        assertThat(entity.getRepo().getName(), is(equalTo("OkBuilds/OkBuck")));
        assertThat(entity.getPayload().getForkee().getId(), is(58443990));
        assertThat(entity.getPayload().getForkee().getName(), is(equalTo("OkBuck")));
        assertThat(entity.getPayload().getForkee().getCreated_at(), is(equalTo("2016-05-10T08:39:14Z")));
        assertThat(entity.getPayload().getForkee().getOwner().getLogin(), is(equalTo("Piasy")));
        assertThat(entity.getPayload().getForkee().getOwner().getUrl(), is(equalTo("https://api.github.com/users/Piasy")));
        assertThat(entity.getOrg().getId(), is(19268334));
        assertThat(entity.getOrg().getLogin(), is(equalTo("OkBuilds")));
    }

    @Test
    public void testTransformHappyCase() {
        ForkEventEntity entity = SugarJson.fromJson(FAKE_FORK_EVENT_JSON, ForkEventEntity.class);
        ForkEvent event = new ForkEvent();
        entity.transform(entity, event);

        assertThat(event.getId(), is(equalTo("3993508642")));
        assertThat(event.getType(), is(equalTo("ForkEvent")));
        assertThat(event.getActor().getId(), is(3098704));
        assertThat(event.getActor().getLogin(), is(equalTo("Piasy")));
        assertThat(event.getRepo().getId(), is(43598554));
        assertThat(event.getRepo().getName(), is(equalTo("OkBuilds/OkBuck")));
        assertThat(event.getPayload().getForkee().getId(), is(58443990));
        assertThat(event.getPayload().getForkee().getName(), is(equalTo("OkBuck")));
        assertThat(event.getPayload().getForkee().getCreated_at(), is(equalTo("2016-05-10T08:39:14Z")));
        assertThat(event.getPayload().getForkee().getOwner().getLogin(), is(equalTo("Piasy")));
        assertThat(event.getPayload().getForkee().getOwner().getUrl(), is(equalTo("https://api.github.com/users/Piasy")));
        assertThat(event.getOrg().getId(), is(19268334));
        assertThat(event.getOrg().getLogin(), is(equalTo("OkBuilds")));
    }
}
