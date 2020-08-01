package com.winks.demo.bean;

import android.app.Activity;

import com.winks.demo.mvvm.NewsContract;
import com.winks.demo.request.base.RequestManager;
import com.winks.demo.request.base.RequestSubscribe;
import com.winks.demo.request.base.RetrofitException;
import com.winks.demo.request.base.RxThreadUtil;
import com.winks.demo.view.activity.DataBindingActivity;

import java.util.List;

public class Feed {

    /**
     * has_more : true
     * message : success
     * data : [{"chinese_tag":"时政","media_avatar_url":"//p9.pstatp.com/large/pgc-image/03f6307ae99745119fa95747f9d9e525","is_feed_ad":false,"tag_url":"search/?keyword=%E6%97%B6%E6%94%BF","title":"习近平给\u201c全球首席执行官委员会\u201d成员代表回信","single_mode":false,"middle_mode":false,"abstract":"习近平在回信中指出，当前，中国正在统筹推进疫情防控和经济社会发展工作，决胜全面建成小康社会，决战脱贫攻坚。","tag":"news_politics","behot_time":1594882679,"source_url":"/group/6849933672448164360/","source":"新华网客户端","more_mode":false,"article_genre":"article","comments_count":123,"is_stick":true,"group_source":2,"item_id":"6849933672448164360","has_gallery":false,"group_id":"6849933672448164360","media_url":"/c/user/token/MS4wLjABAAAAP09LrX61xFpIWrgGdBDqkp-5om9Lans_kuIZ_ipAGRE/"},{"single_mode":false,"abstract":"跟着习近平总书记学好这几门必修课","middle_mode":true,"more_mode":false,"tag":"news_media","comments_count":85,"tag_url":"search/?keyword=%E4%BC%A0%E5%AA%92","title":"跟着习近平总书记学好这几门必修课","chinese_tag":"传媒","source":"人民网","group_source":2,"image_url":"//p1.pstatp.com/list/pgc-image/S4rUhfVEtuJGvz","media_url":"/c/user/token/MS4wLjABAAAA6Ftyf-tftfbjp1u_TEz6kpY77ZlPaYRV0UsfXkF2UsM/","media_avatar_url":"//p1.pstatp.com/large/321a3000c5e6f2b8f8b55","source_url":"/group/6849935731167756814/","article_genre":"article","is_stick":true,"item_id":"6849935731167756814","is_feed_ad":false,"behot_time":1594882229,"has_gallery":false,"group_id":"6849935731167756814","middle_image":"http://p1.pstatp.com/list/pgc-image/S4rUhfVEtuJGvz"},{"media_avatar_url":"//p8.pstatp.com/large/ffbd0000340c79eac0a1","is_feed_ad":false,"tag_url":"search/?keyword=None","title":"四川一副厅长携博士情妇疯狂敛财：帮科技公司拿下国家项目，干股兑现2000万；情妇判刑后拒缴财产被法院强执","single_mode":true,"middle_mode":true,"abstract":"有意思的是，冯沁与谭开林选择的受贿方式不是直接拿钱，而是先拿公司股权，等待\u201c猎物养肥\u201d，科技公司拿到国家的项目和资金，在业内名声大噪获得新融资后，冯沁才开始收网，要求兑现股权，其中从一家公司就拿走2000万元。","tag":"selected","behot_time":1594881329,"source_url":"/group/6849905133665387019/","source":"潇湘新闻","more_mode":false,"article_genre":"article","image_url":"//p1.pstatp.com/list/190x124/pgc-image/b22fd0b6a2b54653962853f63b994f84","has_gallery":false,"group_source":2,"item_id":"6849905133665387019","comments_count":2179,"group_id":"6849905133665387019","middle_image":"http://p1.pstatp.com/list/pgc-image/b22fd0b6a2b54653962853f63b994f84","media_url":"/c/user/token/MS4wLjABAAAAsMBxgp4sO1HoshCb5qMtZvxB0VIW5Ertzq-oaNlfKcK9jm5NKgbTQZTw4SDq6Dd6/"},{"is_feed_ad":false,"tag_url":"search/?keyword=None","ugc_data":{"read_count":65852283,"ugc_images":[],"ugc_user":{"open_url":"/c/user/token/MS4wLjABAAAAg8mQwYyj-soFFv04MS_y4FHXz7BBhvlBHhzbrLws3k4/","user_id":5007907333,"name":"胡锡进","avatar_url":"//p1.pstatp.com/thumb/2bd5002839a55463d555","is_following":false,"is_self":false,"user_verified":1,"user_auth_info":{"auth_type":"1","auth_info":"《环球时报》总编辑"}},"rich_content":"美国媒体传，特朗普政府正在讨论全面禁止所有中共党员和他们的家属赴美旅行，已在美国的中共党员及家属将受到驱逐。这是迄今为止华盛顿最为疯狂的对华政策设想，它被放风拿到媒体上来，都是邪恶的。<br>蓬佩奥星期三宣称，特朗普第二任期的最大挑战是中国共产党，与上述媒体透风形成了呼应。<br>由于禁止所有中共党员和家属赴美旅行需要美国开展一场难以置信的社会运动，而不仅仅是国家机构的简单操作，很多人首先想到的是，特朗普政府突然放这个风的一大目的是为自己助选。他们要展示对中国的空前强硬，进一步煽动美国社会对中国的仇恨，把美国的全部问题都归咎在中国以及中国共产党身上，他们试图在美国人对中国的咬牙切齿中实现胜选连任。<br> <br>为了大选，特朗普政府真的是很拼了。他们把美国搞得像一个邪教国家，诅咒中国被当成了那个国家走出困境的最大宝典。一帮人如果中了邪，那么再怪的招都可能使出来，并且道义感强得让自己感动得想哭。华盛顿现在做事已经没有了全球化时代的基本逻辑，所以美国是否会把禁止中共党员赴美旅行的疯狂想法付诸实施，或者将其部分政策化，还真不好说。<br> <br>华盛顿正在对中美关系进行针对世界和平犯罪级别的破坏，将人类的21世纪推向巨大不确定性中。这一切的发生出乎了所有人的想象，我们不要试图用正常思维去解读地缘政治狂人的歇斯底里了。中国需要接受美国对华态度已经根本性转变的现实，不要再抱幻想。我们需要制定坚定理性的计划，稳住阵脚，恰当应对，与美国开展未来几十年的战略大周旋。<br> <br>这种大周旋将给今天年轻人的人生环境打下烙印，但这决不意味着他们的人生只能\u201c洗洗睡了\u201d。他们的人生起点与老胡这一代完全不可同日而语，他们更有力量，有更多中国人集体的智慧积累，他们将承担扛起中国崛起最关键一段的使命。他们需要创造种种类似在美国被新冠疫情吞没时中国却能将新增病例清零的奇迹来，不断强化中国开展长期竞争的耐力和张力，他们要有能力实现在美国围堵情况下的对外开放，将中国的对外学习与保持自信融为一体。他们还需要要解决如何团结绝大多数国家、让中国的体制被西方更多人理解、让中国民间的爱国主义与其他国家的爱国主义彼此友好兼容等各种问题。<br> <br>中国的未来就寄托在年轻人的身上。<br> ","show_count":65852283,"digg_count":38104,"content":"美国媒体传，特朗普政府正在讨论全面禁止所有中共党员和他们的家属赴美旅行，已在美国的中共党员及家属将受到驱逐。这是迄今为止华盛顿最为疯狂的对华政策设想，它被放风拿到媒体上来，都是邪恶的。\n蓬佩奥星期三宣称，特朗普第二任期的最大挑战是中国共产党，与上述媒体透风形成了呼应。\n由于禁止所有中共党员和家属赴美旅行需要美国开展一场难以置信的社会运动，而不仅仅是国家机构的简单操作，很多人首先想到的是，特朗普政府突然放这个风的一大目的是为自己助选。他们要展示对中国的空前强硬，进一步煽动美国社会对中国的仇恨，把美国的全部问题都归咎在中国以及中国共产党身上，他们试图在美国人对中国的咬牙切齿中实现胜选连任。\n \n为了大选，特朗普政府真的是很拼了。他们把美国搞得像一个邪教国家，诅咒中国被当成了那个国家走出困境的最大宝典。一帮人如果中了邪，那么再怪的招都可能使出来，并且道义感强得让自己感动得想哭。华盛顿现在做事已经没有了全球化时代的基本逻辑，所以美国是否会把禁止中共党员赴美旅行的疯狂想法付诸实施，或者将其部分政策化，还真不好说。\n \n华盛顿正在对中美关系进行针对世界和平犯罪级别的破坏，将人类的21世纪推向巨大不确定性中。这一切的发生出乎了所有人的想象，我们不要试图用正常思维去解读地缘政治狂人的歇斯底里了。中国需要接受美国对华态度已经根本性转变的现实，不要再抱幻想。我们需要制定坚定理性的计划，稳住阵脚，恰当应对，与美国开展未来几十年的战略大周旋。\n \n这种大周旋将给今天年轻人的人生环境打下烙印，但这决不意味着他们的人生只能\u201c洗洗睡了\u201d。他们的人生起点与老胡这一代完全不可同日而语，他们更有力量，有更多中国人集体的智慧积累，他们将承担扛起中国崛起最关键一段的使命。他们需要创造种种类似在美国被新冠疫情吞没时中国却能将新增病例清零的奇迹来，不断强化中国开展长期竞争的耐力和张力，他们要有能力实现在美国围堵情况下的对外开放，将中国的对外学习与保持自信融为一体。他们还需要要解决如何团结绝大多数国家、让中国的体制被西方更多人理解、让中国民间的爱国主义与其他国家的爱国主义彼此友好兼容等各种问题。\n \n中国的未来就寄托在年轻人的身上。\n ","comment_count":18070,"show_text":"展现","display_count":65852283},"title":"美国媒体传，特朗普政府正在讨论全面禁止所有中共党员和他们的家属赴美旅行，已在美国的中共党员及家属将受到驱逐。这是迄今为止华盛顿最为疯狂的对华政策设想，它被放风拿到媒体上来，都是邪恶的。\n蓬佩奥星期三宣称，特朗普第二任期的最大挑战是中国共产党，与上述媒体透风形成了呼应。\n由于禁止所有中共党员和家属赴美","single_mode":false,"middle_mode":false,"abstract":"美国媒体传，特朗普政府正在讨论全面禁止所有中共党员和他们的家属赴美旅行，已在美国的中共党员及家属将受到驱逐。这是迄今为止华盛顿最为疯狂的对华政策设想，它被放风拿到媒体上来，都是邪恶的。蓬佩奥星期三宣称，特朗普第二任期的最大挑战是中国共产党，与上述媒体透风形成了呼应。","tag":"forum_post","behot_time":1594880429,"source_url":"/group/1672346781079564/","source":"胡锡进","more_mode":false,"article_genre":"ugc","comments_count":669,"group_source":5,"item_id":"1672346781079564","has_gallery":false,"group_id":"1672346781079564","media_url":"/c/user/token/MS4wLjABAAAAg8mQwYyj-soFFv04MS_y4FHXz7BBhvlBHhzbrLws3k4/"},{"single_mode":true,"abstract":"出师未捷，半路就已\u201c损兵过半\u201d，最终无奈落得个惨败!该营的经历同时告诉我们，战斗一旦打响，没有旁观者，更没有局外人，人人都是参与者，个个都是战斗员。","middle_mode":true,"more_mode":false,"tag":"news_military","comments_count":12,"tag_url":"news_military","title":"一辆\u201c编外\u201d加油车\u201c毁\u201d掉半个营","chinese_tag":"军事","source":"中工网","group_source":2,"has_gallery":false,"media_url":"/c/user/token/MS4wLjABAAAAMnblevmY0Qt-QgRg_pKWHVMrbv_lg0VMmEMpEEOk6Vw/","media_avatar_url":"//p1-dy.bytexservice.com/large/pgc-image/c0ce22840583488ab032fef9a5da462c","source_url":"/group/6849881156456808973/","article_genre":"article","item_id":"6849881156456808973","is_feed_ad":false,"behot_time":1594879529,"image_url":"//p3.pstatp.com/list/190x124/pgc-image/S4rXPkCFFenFVo","group_id":"6849881156456808973","middle_image":"http://p3.pstatp.com/list/pgc-image/S4rXPkCFFenFVo"},{"single_mode":true,"abstract":"7月15日，随着国家图书馆站最后一个钢轨焊缝对接顺利完成，北京地铁16号线中段工程如期实现了长轨贯通节点目标，为2020年底实现初期运营打下了坚实的基础。","middle_mode":true,"more_mode":true,"tag":"news_society","comments_count":8,"tag_url":"news_society","title":"北京地铁16号线中段全线长轨贯通","chinese_tag":"社会","source":"经济日报","group_source":2,"has_gallery":false,"media_url":"/c/user/token/MS4wLjABAAAA5JuEG4IbWQVcLLZHN-v2J880oGjJOgG0K5H7bYpCHbI/","media_avatar_url":"//p2.pstatp.com/large/user-avatar/c0d83b3212f89c452d5d73220acf38ae","image_list":[{"url":"//p9.pstatp.com/list/pgc-image/S4n1mBv9eJgQGz"},{"url":"//p1.pstatp.com/list/pgc-image/S4nfnGBuhjNXf"},{"url":"//p1.pstatp.com/list/pgc-image/S4nfnGqI1II7ZP"}],"source_url":"/group/6849635886410236423/","article_genre":"article","item_id":"6849635886410236423","is_feed_ad":false,"behot_time":1594879079,"image_url":"//p9.pstatp.com/list/190x124/pgc-image/S4n1mBv9eJgQGz","group_id":"6849635886410236423","middle_image":"http://p9.pstatp.com/list/pgc-image/S4n1mBv9eJgQGz"}]
     * next : {"max_behot_time":1594879079}
     */

    private boolean has_more;
    private String message;
    private NextBean next;
    private List<News> data;

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NextBean getNext() {
        return next;
    }

    public void setNext(NextBean next) {
        this.next = next;
    }

    public List<News> getData() {
        return data;
    }

    public void setData(List<News> data) {
        this.data = data;
    }

    public static class NextBean {
    }
    public void load(NewsContract.view view){
        RequestManager.getInstance().getApi.getNews()
                .compose(RxThreadUtil.rxObservableSchedulerHelper())
                .subscribe(new RequestSubscribe<Feed>() {
                    @Override
                    protected void onRequestSuccess(Feed response) {
                        if (view!=null){
                            view.onSuccess(response);
                        }
                    }

                    @Override
                    protected void onRequestError(RetrofitException.ResponeThrowable throwable) {
                        if (view!=null){
                            view.onError(throwable);
                        }
                    }

                    @Override
                    protected void onNetWorkError() {

                    }
                });
    }
}
