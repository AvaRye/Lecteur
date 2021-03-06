package com.example.lecteur.myListDetail

data class TraDetail(
    val code: Int,
    val playlist: Playlist,
    val privileges: List<Privilege>
)

data class Playlist(
    val adType: Int,
    val cloudTrackCount: Int,
    val commentCount: Int,
    val commentThreadId: String,
    val coverImgId: Long,
    val coverImgUrl: String,
    val createTime: Long,
    val creator: Creator,
    val description: Any,
    val highQuality: Boolean,
    val id: Long,
    val name: String,
    val newImported: Boolean,
    val ordered: Boolean,
    val playCount: Int,
    val privacy: Int,
    val shareCount: Int,
    val specialType: Int,
    val status: Int,
    val subscribed: Boolean,
    val subscribedCount: Int,
    val subscribers: List<Any>,
    val tags: List<Any>,
    val trackCount: Int,
    val trackIds: List<TrackId>,
    val trackNumberUpdateTime: Long,
    val trackUpdateTime: Long,
    val tracks: List<Track>,
    val updateTime: Long,
    val userId: Int
)

data class Track(
    val a: Any,
    val al: Al,
    val alia: List<Any>,
    val ar: List<Ar>,
    val cd: String,
    val cf: String,
    val copyright: Int,
    val cp: Int,
    val crbt: Any,
    val djId: Int,
    val dt: Int,
    val fee: Int,
    val ftype: Int,
    val h: H,
    val id: Int,
    val l: L,
    val m: M,
    val mst: Int,
    val mv: Int,
    val name: String,
    val no: Int,
    val pop: Int,
    val pst: Int,
    val publishTime: Long,
    val rt: String,
    val rtUrl: Any,
    val rtUrls: List<Any>,
    val rtype: Int,
    val rurl: Any,
    val s_id: Int,
    val st: Int,
    val t: Int,
    val v: Int
)

data class L(
    val br: Int,
    val fid: Int,
    val size: Int,
    val vd: Double
)

data class Al(
    val id: Int,
    val name: String,
    val pic: Long,
    val picUrl: String,
    val tns: List<Any>
)

data class Ar(
    val alias: List<Any>,
    val id: Int,
    val name: String,
    val tns: List<Any>
)

data class M(
    val br: Int,
    val fid: Int,
    val size: Int,
    val vd: Double
)

data class H(
    val br: Int,
    val fid: Int,
    val size: Int,
    val vd: Double
)

data class Creator(
    val accountStatus: Int,
    val authStatus: Int,
    val authority: Int,
    val avatarImgId: Long,
    val avatarImgIdStr: String,
    val avatarImgId_str: String,
    val avatarUrl: String,
    val backgroundImgId: Long,
    val backgroundImgIdStr: String,
    val backgroundUrl: String,
    val birthday: Long,
    val city: Int,
    val defaultAvatar: Boolean,
    val description: String,
    val detailDescription: String,
    val djStatus: Int,
    val expertTags: Any,
    val experts: Any,
    val followed: Boolean,
    val gender: Int,
    val mutual: Boolean,
    val nickname: String,
    val province: Int,
    val remarkName: Any,
    val signature: String,
    val userId: Int,
    val userType: Int,
    val vipType: Int
)

data class TrackId(
    val id: Int,
    val v: Int
)

data class Privilege(
    val cp: Int,
    val cs: Boolean,
    val dl: Int,
    val fee: Int,
    val fl: Int,
    val flag: Int,
    val id: Int,
    val maxbr: Int,
    val payed: Int,
    val pl: Int,
    val preSell: Boolean,
    val sp: Int,
    val st: Int,
    val subp: Int,
    val toast: Boolean
)