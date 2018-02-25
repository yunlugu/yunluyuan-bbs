package com.laoer.bbscs.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.laoer.bbscs.bean.Board;
import com.laoer.bbscs.bean.Forum;
import com.laoer.bbscs.bean.UserInfo;
import com.laoer.bbscs.comm.BBSCSUtil;
import com.laoer.bbscs.comm.Constant;
import com.laoer.bbscs.service.BoardService;
import com.laoer.bbscs.service.ForumService;
import com.laoer.bbscs.service.FriendService;
import com.laoer.bbscs.service.NoteService;
import com.laoer.bbscs.service.SysStatService;
import com.laoer.bbscs.service.UserOnlineService;
import com.laoer.bbscs.service.UserService;
import com.laoer.bbscs.service.config.SysConfig;
import com.laoer.bbscs.web.interceptor.RequestBasePathAware;

public class In extends BaseMainAction implements RequestBasePathAware {

	/**
	 *
	 */
	private static final long serialVersionUID = 470483826099960657L;

	private String basePath;

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public String getBasePath() {
		return basePath;
	}

	private UserService userService;

	private NoteService noteService;

	private FriendService friendService;

	private UserOnlineService userOnlineService;

	private ForumService forumService;

	private SysConfig sysConfig;

	private SysStatService sysStatService;

	private BoardService boardService;

	public BoardService getBoardService() {
		return boardService;
	}

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	public ForumService getForumService() {
		return forumService;
	}

	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}

	public FriendService getFriendService() {
		return friendService;
	}

	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}

	public NoteService getNoteService() {
		return noteService;
	}

	public void setNoteService(NoteService noteService) {
		this.noteService = noteService;
	}

	public SysConfig getSysConfig() {
		return sysConfig;
	}

	public void setSysConfig(SysConfig sysConfig) {
		this.sysConfig = sysConfig;
	}

	public SysStatService getSysStatService() {
		return sysStatService;
	}

	public void setSysStatService(SysStatService sysStatService) {
		this.sysStatService = sysStatService;
	}

	public UserOnlineService getUserOnlineService() {
		return userOnlineService;
	}

	public void setUserOnlineService(UserOnlineService userOnlineService) {
		this.userOnlineService = userOnlineService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private String onlineHighest;

	public String getOnlineHighest() {
		return onlineHighest;
	}

	public void setOnlineHighest(String onlineHighest) {
		this.onlineHighest = onlineHighest;
	}

	private String sysinfo;

	public String getSysinfo() {
		return sysinfo;
	}

	public void setSysinfo(String sysinfo) {
		this.sysinfo = sysinfo;
	}

	private Date lastLoginTime;

	private int titleValue;

	private String userTitle;

	private long newNoteNumInbox;

	private long noteAllNumInbox;

	private long friendNum;

	private long onlineNum;

	private long onlineGuestNum;

	private long friendOnlineNum;

	private boolean guest;

	private List<Forum> newForums = new ArrayList<Forum>();

	public List<Forum> getNewForums() {
		return newForums;
	}

	public void setNewForums(List<Forum> newForums) {
		this.newForums = newForums;
	}

	public long getFriendNum() {
		return friendNum;
	}

	public void setFriendNum(long friendNum) {
		this.friendNum = friendNum;
	}

	public long getFriendOnlineNum() {
		return friendOnlineNum;
	}

	public void setFriendOnlineNum(long friendOnlineNum) {
		this.friendOnlineNum = friendOnlineNum;
	}

	public boolean isGuest() {
		return guest;
	}

	public void setGuest(boolean guest) {
		this.guest = guest;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public long getNewNoteNumInbox() {
		return newNoteNumInbox;
	}

	public void setNewNoteNumInbox(long newNoteNumInbox) {
		this.newNoteNumInbox = newNoteNumInbox;
	}

	public long getNoteAllNumInbox() {
		return noteAllNumInbox;
	}

	public void setNoteAllNumInbox(long noteAllNumInbox) {
		this.noteAllNumInbox = noteAllNumInbox;
	}

	public long getOnlineGuestNum() {
		return onlineGuestNum;
	}

	public void setOnlineGuestNum(long onlineGuestNum) {
		this.onlineGuestNum = onlineGuestNum;
	}

	public long getOnlineNum() {
		return onlineNum;
	}

	public void setOnlineNum(long onlineNum) {
		this.onlineNum = onlineNum;
	}

	public int getTitleValue() {
		return titleValue;
	}

	public void setTitleValue(int titleValue) {
		this.titleValue = titleValue;
	}

	public String getUserTitle() {
		return userTitle;
	}

	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle;
	}

	private List boardList = new ArrayList();

	public List getBoardList() {
		return boardList;
	}

	public void setBoardList(List boardList) {
		this.boardList = boardList;
	}

	private Map<Long, List> boardMap = new HashMap<Long, List>();

	public Map<Long, List> getBoardMap() {
		return boardMap;
	}

	public void setBoardMap(Map<Long, List> boardMap) {
		this.boardMap = boardMap;
	}

	private boolean urlRewrite = false;

	public boolean isUrlRewrite() {
		return urlRewrite;
	}

	public void setUrlRewrite(boolean urlRewrite) {
		this.urlRewrite = urlRewrite;
	}

	private boolean usePass;

	public boolean isUsePass() {
		return usePass;
	}

	public void setUsePass(boolean usePass) {
		this.usePass = usePass;
	}

	private String actionUrl;

	private String tourl;

	public String getActionUrl() {
		return actionUrl;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	public String getTourl() {
		return tourl;
	}

	public void setTourl(String tourl) {
		this.tourl = tourl;
	}

	private String forumSite = "bbs.laoer.com";

	public String getForumSite() {
		return forumSite;
	}

	public void setForumSite(String forumSite) {
		this.forumSite = forumSite;
	}

	private boolean useAuthCode = true;

	public boolean isUseAuthCode() {
		return useAuthCode;
	}

	public void setUseAuthCode(boolean useAuthCode) {
		this.useAuthCode = useAuthCode;
	}

	public String execute() {
		return this.index();
	}

	public String index() {
		int isHidden = 0;
		if (this.getUserSession().isHaveSpecialPermission(Constant.SPERMISSION_CAN_SEE_HIDDEN_BOARD)) { // 如果用户有查看隐藏版区的权限
			isHidden = -1;
		}
		UserInfo ui = this.getUserService().findUserInfoById(this.getUserSession().getId());
		long atime = System.currentTimeMillis() - (this.getSysConfig().getUserOnlineTime() * 1000);

		long onlineNum = this.getUserOnlineService().getUserOnlineNum(atime, 0, 0, Constant.NORMAL_USER_GROUPS);
		long onlineGuestNum = this.getUserOnlineService().getUserOnlineNum(atime, 0, 0, Constant.GUEST_USER_GROUPS);

		this.getSysStatService().saveOnline(onlineNum + onlineGuestNum);

		this
				.setOnlineHighest(this.getText("bbscs.onlinehighest", new String[] {
						String.valueOf(this.getSysStatService().getOnlineNum()),
						this.getSysStatService().getAppearTimeStr() }));

		String reguserurl = "<a href=\""
				+ this.getBasePath()
				+ BBSCSUtil.getActionMappingURLWithoutPrefix("userInfo?action=name&username="
						+ this.getSysStatService().getLastRegUser()) + "\">"
				+ this.getSysStatService().getLastRegUser() + "</a>";

		this.setSysinfo(this.getText("bbscs.sysinfo", new String[] {
				String.valueOf(this.getSysStatService().getPostMainNum()),
				String.valueOf(this.getSysStatService().getPostNum()),
				String.valueOf(this.getSysStatService().getAllUserNum()), reguserurl }));

		this.setOnlineNum(onlineNum);
		this.setOnlineGuestNum(onlineGuestNum);

		if (ui == null || this.getUserSession().getGroupID() == Constant.USER_GROUP_GUEST) {
			this.setLastLoginTime(new Date());
			this.setTitleValue(0);
			ui = null;
			this.setUserTitle(this.getUserService().getUserTitle(ui));
			this.setNewNoteNumInbox(0);
			this.setNoteAllNumInbox(0);
			this.setFriendNum(0);
			this.setFriendOnlineNum(0);
			this.setGuest(true);
		} else {
			this.setLastLoginTime(ui.getLastLoginTime());
			this.setTitleValue(this.getUserService().getUserTitleValue(ui));
			this.setUserTitle(this.getUserService().getUserTitle(ui));

			this.setNewNoteNumInbox(this.getNoteService().getNoteNumInBoxByIsNew(this.getUserSession().getId(), 1));
			this.setNoteAllNumInbox(this.getNoteService().getNoteAllNumInBox(this.getUserSession().getId()));

			this.setFriendNum(this.getFriendService().getFriendNum(this.getUserSession().getId(), 0));
			long foNum = this.getUserOnlineService().getUserOnlineNumInIds(atime,
					this.getFriendService().findFriendIds(this.getUserSession().getId(), 0), 0, 0,
					Constant.NORMAL_USER_GROUPS);
			this.setFriendOnlineNum(foNum);
			this.setGuest(false);
		}

		List newfs = this.getForumService().findForumsAllNewCache(50);
		if (newfs.size() > 10) {
			for (int i = 0; i < 10; i++) {
				this.newForums.add((Forum) newfs.get(i));
			}
		} else {
			for (int i = 0; i < newfs.size(); i++) {
				this.newForums.add((Forum) newfs.get(i));
			}
		}

		this.setUrlRewrite(Constant.USE_URL_REWRITE);
		this.boardList = this.getBoardService().findBoardsByParentID(0, 1, isHidden, Constant.FIND_BOARDS_BY_ORDER);

		for (int i = 0; i < this.boardList.size(); i++) {
			Board b = (Board) this.boardList.get(i);
			List bclist = this.getBoardService().findBoardsByParentID(b.getId(), 1, isHidden,
					Constant.FIND_BOARDS_BY_ORDER);
			this.boardMap.put(b.getId(), bclist);
		}

		this.setUsePass(this.getSysConfig().isUsePass());
		this.setUseAuthCode(this.getSysConfig().isUseAuthCode());

		if (Constant.USE_URL_REWRITE) {
			tourl = this.getBasePath() + "main.html";
		} else {
			tourl = this.getBasePath() + BBSCSUtil.getActionMappingURLWithoutPrefix("main");
		}

		if (this.getSysConfig().isUsePass()) {
			this.setActionUrl(this.getSysConfig().getPassUrl());
		} else {
			this.setActionUrl(this.getBasePath() + BBSCSUtil.getActionMappingURLWithoutPrefix("login"));
		}
		this.setForumSiteInit();
		return SUCCESS;
	}

	private void setForumSiteInit() {
		String url = this.getSysConfig().getForumUrl();
		if (url == null) {
			url = "bbs.laoer.com";
		} else if (url.startsWith("http://")) {
			url = url.substring("http://".length(), url.length());
		}
		this.setForumSite(url);
	}

}
