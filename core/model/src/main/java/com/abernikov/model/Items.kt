package com.abernikov.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Items(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("node_id") var nodeId: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("full_name") var fullName: String? = null,
    @SerializedName("private") var private: Boolean? = null,
    @SerializedName("owner") var owner: Owner? = Owner(),
    @SerializedName("html_url") var htmlUrl: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("fork") var fork: Boolean? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("forks_url") var forksUrl: String? = null,
    @SerializedName("keys_url") var keysUrl: String? = null,
    @SerializedName("collaborators_url") var collaboratorsUrl: String? = null,
    @SerializedName("teams_url") var teamsUrl: String? = null,
    @SerializedName("hooks_url") var hooksUrl: String? = null,
    @SerializedName("issue_events_url") var issueEventsUrl: String? = null,
    @SerializedName("events_url") var eventsUrl: String? = null,
    @SerializedName("assignees_url") var assigneesUrl: String? = null,
    @SerializedName("branches_url") var branchesUrl: String? = null,
    @SerializedName("tags_url") var tagsUrl: String? = null,
    @SerializedName("blobs_url") var blobsUrl: String? = null,
    @SerializedName("git_tags_url") var gitTagsUrl: String? = null,
    @SerializedName("git_refs_url") var gitRefsUrl: String? = null,
    @SerializedName("trees_url") var treesUrl: String? = null,
    @SerializedName("statuses_url") var statusesUrl: String? = null,
    @SerializedName("languages_url") var languagesUrl: String? = null,
    @SerializedName("stargazers_url") var stargazersUrl: String? = null,
    @SerializedName("contributors_url") var contributorsUrl: String? = null,
    @SerializedName("subscribers_url") var subscribersUrl: String? = null,
    @SerializedName("subscription_url") var subscriptionUrl: String? = null,
    @SerializedName("commits_url") var commitsUrl: String? = null,
    @SerializedName("git_commits_url") var gitCommitsUrl: String? = null,
    @SerializedName("comments_url") var commentsUrl: String? = null,
    @SerializedName("issue_comment_url") var issueCommentUrl: String? = null,
    @SerializedName("contents_url") var contentsUrl: String? = null,
    @SerializedName("compare_url") var compareUrl: String? = null,
    @SerializedName("merges_url") var mergesUrl: String? = null,
    @SerializedName("archive_url") var archiveUrl: String? = null,
    @SerializedName("downloads_url") var downloadsUrl: String? = null,
    @SerializedName("issues_url") var issuesUrl: String? = null,
    @SerializedName("pulls_url") var pullsUrl: String? = null,
    @SerializedName("milestones_url") var milestonesUrl: String? = null,
    @SerializedName("notifications_url") var notificationsUrl: String? = null,
    @SerializedName("labels_url") var labelsUrl: String? = null,
    @SerializedName("releases_url") var releasesUrl: String? = null,
    @SerializedName("deployments_url") var deploymentsUrl: String? = null,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null,
    @SerializedName("pushed_at") var pushedAt: String? = null,
    @SerializedName("git_url") var gitUrl: String? = null,
    @SerializedName("ssh_url") var sshUrl: String? = null,
    @SerializedName("clone_url") var cloneUrl: String? = null,
    @SerializedName("svn_url") var svnUrl: String? = null,
    @SerializedName("homepage") var homepage: String? = null,
    @SerializedName("size") var size: Int? = null,
    @SerializedName("stargazers_count") var stargazersCount: Int? = null,
    @SerializedName("watchers_count") var watchersCount: Int? = null,
    @SerializedName("language") var language: String? = null,
    @SerializedName("has_issues") var hasIssues: Boolean? = null,
    @SerializedName("has_projects") var hasProjects: Boolean? = null,
    @SerializedName("has_downloads") var hasDownloads: Boolean? = null,
    @SerializedName("has_wiki") var hasWiki: Boolean? = null,
    @SerializedName("has_pages") var hasPages: Boolean? = null,
    @SerializedName("has_discussions") var hasDiscussions: Boolean? = null,
    @SerializedName("forks_count") var forksCount: Int? = null,
    @SerializedName("mirror_url") var mirrorUrl: String? = null,
    @SerializedName("archived") var archived: Boolean? = null,
    @SerializedName("disabled") var disabled: Boolean? = null,
    @SerializedName("open_issues_count") var openIssuesCount: Int? = null,
    @SerializedName("license") var license: License? = License(),
    @SerializedName("allow_forking") var allowForking: Boolean? = null,
    @SerializedName("is_template") var isTemplate: Boolean? = null,
    @SerializedName("web_commit_signoff_required") var webCommitSignoffRequired: Boolean? = null,
    @SerializedName("topics") var topics: ArrayList<String> = arrayListOf(),
    @SerializedName("visibility") var visibility: String? = null,
    @SerializedName("forks") var forks: Int? = null,
    @SerializedName("open_issues") var openIssues: Int? = null,
    @SerializedName("watchers") var watchers: Int? = null,
    @SerializedName("default_branch") var defaultBranch: String? = null,
    @SerializedName("score") var score: Int? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        TODO("owner"),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        TODO("license"),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        TODO("topics"),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(nodeId)
        parcel.writeString(name)
        parcel.writeString(fullName)
        parcel.writeValue(private)
        parcel.writeString(htmlUrl)
        parcel.writeString(description)
        parcel.writeValue(fork)
        parcel.writeString(url)
        parcel.writeString(forksUrl)
        parcel.writeString(keysUrl)
        parcel.writeString(collaboratorsUrl)
        parcel.writeString(teamsUrl)
        parcel.writeString(hooksUrl)
        parcel.writeString(issueEventsUrl)
        parcel.writeString(eventsUrl)
        parcel.writeString(assigneesUrl)
        parcel.writeString(branchesUrl)
        parcel.writeString(tagsUrl)
        parcel.writeString(blobsUrl)
        parcel.writeString(gitTagsUrl)
        parcel.writeString(gitRefsUrl)
        parcel.writeString(treesUrl)
        parcel.writeString(statusesUrl)
        parcel.writeString(languagesUrl)
        parcel.writeString(stargazersUrl)
        parcel.writeString(contributorsUrl)
        parcel.writeString(subscribersUrl)
        parcel.writeString(subscriptionUrl)
        parcel.writeString(commitsUrl)
        parcel.writeString(gitCommitsUrl)
        parcel.writeString(commentsUrl)
        parcel.writeString(issueCommentUrl)
        parcel.writeString(contentsUrl)
        parcel.writeString(compareUrl)
        parcel.writeString(mergesUrl)
        parcel.writeString(archiveUrl)
        parcel.writeString(downloadsUrl)
        parcel.writeString(issuesUrl)
        parcel.writeString(pullsUrl)
        parcel.writeString(milestonesUrl)
        parcel.writeString(notificationsUrl)
        parcel.writeString(labelsUrl)
        parcel.writeString(releasesUrl)
        parcel.writeString(deploymentsUrl)
        parcel.writeString(createdAt)
        parcel.writeString(updatedAt)
        parcel.writeString(pushedAt)
        parcel.writeString(gitUrl)
        parcel.writeString(sshUrl)
        parcel.writeString(cloneUrl)
        parcel.writeString(svnUrl)
        parcel.writeString(homepage)
        parcel.writeValue(size)
        parcel.writeValue(stargazersCount)
        parcel.writeValue(watchersCount)
        parcel.writeString(language)
        parcel.writeValue(hasIssues)
        parcel.writeValue(hasProjects)
        parcel.writeValue(hasDownloads)
        parcel.writeValue(hasWiki)
        parcel.writeValue(hasPages)
        parcel.writeValue(hasDiscussions)
        parcel.writeValue(forksCount)
        parcel.writeString(mirrorUrl)
        parcel.writeValue(archived)
        parcel.writeValue(disabled)
        parcel.writeValue(openIssuesCount)
        parcel.writeValue(allowForking)
        parcel.writeValue(isTemplate)
        parcel.writeValue(webCommitSignoffRequired)
        parcel.writeString(visibility)
        parcel.writeValue(forks)
        parcel.writeValue(openIssues)
        parcel.writeValue(watchers)
        parcel.writeString(defaultBranch)
        parcel.writeValue(score)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Items> {
        override fun createFromParcel(parcel: Parcel): Items {
            return Items(parcel)
        }

        override fun newArray(size: Int): Array<Items?> {
            return arrayOfNulls(size)
        }
    }
}