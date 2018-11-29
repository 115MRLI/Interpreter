package printer.test.interpreter;

import java.util.List;

/**
 * 聚告数据返回
 */
public class ResponseData {

    /**
     * adid : 1dfc8b82ccde162e
     * returncode : 200
     * ads : [{"thclkurl":["http://app-tj.adinall.com/tj?key=1dfc8b82ccde162e-mt-click&rd=1543245432.143&req=YWRpZD0xZGZjOGI4MmNjZGUxNjJlJmFkdHlwZT0xJndpZHRoPTY0MCZoZWlnaHQ9MTAwJnBrZ25hbWU9Y29tLmppZWFuZGEucXVhbmd1b3NzZ2pjeCZhcHBuYW1lPSUyNUU1JTI1ODUlMjVBOCUyNUU1JTI1OUIlMjVCRCUyNUU1JTI1ODUlMjVBQyUyNUU0JTI1QkElMjVBNCUyNUU2JTI1OUYlMjVBNSUyNUU4JTI1QUYlMjVBMiZ1YT1Nb3ppbGxhJTI1MkY1LjAlMkIlMjUyOExpbnV4JTI1M0IlMkJBbmRyb2lkJTJCNi4wJTI1M0IlMkJWMXMlMkJCdWlsZCUyNTJGTVJBNThLJTI1M0IlMkJ3diUyNTI5JTJCQXBwbGVXZWJLaXQlMjUyRjUzNy4zNiUyQiUyNTI4S0hUTUwlMjUyQyUyQmxpa2UlMkJHZWNrbyUyNTI5JTJCVmVyc2lvbiUyNTJGNC4wJTJCQ2hyb21lJTI1MkY2Mi4wLjMyMDIuNzMlMkJNb2JpbGUlMkJTYWZhcmklMjUyRjUzNy4zNiZvcz0wJm9zdj0yMyZhcHB2PTEuMS4wJmNhcnJpZXI9MSZjb25uPTQmaXA9MTkyLjE2OC4wLjEwNCZicmFuZD1ub2tpYSZtb2RlbD1uNzAmdXVpZD04NjUxNTAwMzIzMjM0MzUmcHc9NzIwJnBoPTEyODA=&token=dcb496cda2c0666808941009ee3df9b5&__ABZMX__=&__ABZMY__=&__OFFSET_X__=&OFFSET_Y__=&EVENT_TIME_START__=&__EVENT_TIME_END__="],"imgurl":"http://img.adinall.com/app/640x100.jpg","admt":2,"imgtracking":["http://app-tj.adinall.com/tj?key=1dfc8b82ccde162e-mt-view&rd=1543245432.143&req=YWRpZD0xZGZjOGI4MmNjZGUxNjJlJmFkdHlwZT0xJndpZHRoPTY0MCZoZWlnaHQ9MTAwJnBrZ25hbWU9Y29tLmppZWFuZGEucXVhbmd1b3NzZ2pjeCZhcHBuYW1lPSUyNUU1JTI1ODUlMjVBOCUyNUU1JTI1OUIlMjVCRCUyNUU1JTI1ODUlMjVBQyUyNUU0JTI1QkElMjVBNCUyNUU2JTI1OUYlMjVBNSUyNUU4JTI1QUYlMjVBMiZ1YT1Nb3ppbGxhJTI1MkY1LjAlMkIlMjUyOExpbnV4JTI1M0IlMkJBbmRyb2lkJTJCNi4wJTI1M0IlMkJWMXMlMkJCdWlsZCUyNTJGTVJBNThLJTI1M0IlMkJ3diUyNTI5JTJCQXBwbGVXZWJLaXQlMjUyRjUzNy4zNiUyQiUyNTI4S0hUTUwlMjUyQyUyQmxpa2UlMkJHZWNrbyUyNTI5JTJCVmVyc2lvbiUyNTJGNC4wJTJCQ2hyb21lJTI1MkY2Mi4wLjMyMDIuNzMlMkJNb2JpbGUlMkJTYWZhcmklMjUyRjUzNy4zNiZvcz0wJm9zdj0yMyZhcHB2PTEuMS4wJmNhcnJpZXI9MSZjb25uPTQmaXA9MTkyLjE2OC4wLjEwNCZicmFuZD1ub2tpYSZtb2RlbD1uNzAmdXVpZD04NjUxNTAwMzIzMjM0MzUmcHc9NzIwJnBoPTEyODA=&token=dcb496cda2c0666808941009ee3df9b5&__ABZMX__=&__ABZMY__=&__OFFSET_X__=&OFFSET_Y__=&EVENT_TIME_START__=&__EVENT_TIME_END__="],"adct":1,"clickurl":"http://www.adinall.com/"}]
     * adnum : 1
     */

    private String adid;
    private String returncode;
    private String adnum;
    private List<AdsBean> ads;

    public String getAdid() {
        return adid;
    }

    public void setAdid(String adid) {
        this.adid = adid;
    }

    public String getReturncode() {
        return returncode;
    }

    public void setReturncode(String returncode) {
        this.returncode = returncode;
    }

    public String getAdnum() {
        return adnum;
    }

    public void setAdnum(String adnum) {
        this.adnum = adnum;
    }

    public List<AdsBean> getAds() {
        return ads;
    }

    public void setAds(List<AdsBean> ads) {
        this.ads = ads;
    }

    @Override
    public String toString() {
        return "ResponseData{" + "adid='" + adid + '\'' + ", returncode='" + returncode + '\'' + ", adnum='" + adnum + '\'' + ", ads=" + ads + '}';
    }

    public static class AdsBean {
        /**
         * thclkurl : ["http://app-tj.adinall.com/tj?key=1dfc8b82ccde162e-mt-click&rd=1543245432.143&req=YWRpZD0xZGZjOGI4MmNjZGUxNjJlJmFkdHlwZT0xJndpZHRoPTY0MCZoZWlnaHQ9MTAwJnBrZ25hbWU9Y29tLmppZWFuZGEucXVhbmd1b3NzZ2pjeCZhcHBuYW1lPSUyNUU1JTI1ODUlMjVBOCUyNUU1JTI1OUIlMjVCRCUyNUU1JTI1ODUlMjVBQyUyNUU0JTI1QkElMjVBNCUyNUU2JTI1OUYlMjVBNSUyNUU4JTI1QUYlMjVBMiZ1YT1Nb3ppbGxhJTI1MkY1LjAlMkIlMjUyOExpbnV4JTI1M0IlMkJBbmRyb2lkJTJCNi4wJTI1M0IlMkJWMXMlMkJCdWlsZCUyNTJGTVJBNThLJTI1M0IlMkJ3diUyNTI5JTJCQXBwbGVXZWJLaXQlMjUyRjUzNy4zNiUyQiUyNTI4S0hUTUwlMjUyQyUyQmxpa2UlMkJHZWNrbyUyNTI5JTJCVmVyc2lvbiUyNTJGNC4wJTJCQ2hyb21lJTI1MkY2Mi4wLjMyMDIuNzMlMkJNb2JpbGUlMkJTYWZhcmklMjUyRjUzNy4zNiZvcz0wJm9zdj0yMyZhcHB2PTEuMS4wJmNhcnJpZXI9MSZjb25uPTQmaXA9MTkyLjE2OC4wLjEwNCZicmFuZD1ub2tpYSZtb2RlbD1uNzAmdXVpZD04NjUxNTAwMzIzMjM0MzUmcHc9NzIwJnBoPTEyODA=&token=dcb496cda2c0666808941009ee3df9b5&__ABZMX__=&__ABZMY__=&__OFFSET_X__=&OFFSET_Y__=&EVENT_TIME_START__=&__EVENT_TIME_END__="]
         * imgurl : http://img.adinall.com/app/640x100.jpg
         * admt : 2
         * imgtracking : ["http://app-tj.adinall.com/tj?key=1dfc8b82ccde162e-mt-view&rd=1543245432.143&req=YWRpZD0xZGZjOGI4MmNjZGUxNjJlJmFkdHlwZT0xJndpZHRoPTY0MCZoZWlnaHQ9MTAwJnBrZ25hbWU9Y29tLmppZWFuZGEucXVhbmd1b3NzZ2pjeCZhcHBuYW1lPSUyNUU1JTI1ODUlMjVBOCUyNUU1JTI1OUIlMjVCRCUyNUU1JTI1ODUlMjVBQyUyNUU0JTI1QkElMjVBNCUyNUU2JTI1OUYlMjVBNSUyNUU4JTI1QUYlMjVBMiZ1YT1Nb3ppbGxhJTI1MkY1LjAlMkIlMjUyOExpbnV4JTI1M0IlMkJBbmRyb2lkJTJCNi4wJTI1M0IlMkJWMXMlMkJCdWlsZCUyNTJGTVJBNThLJTI1M0IlMkJ3diUyNTI5JTJCQXBwbGVXZWJLaXQlMjUyRjUzNy4zNiUyQiUyNTI4S0hUTUwlMjUyQyUyQmxpa2UlMkJHZWNrbyUyNTI5JTJCVmVyc2lvbiUyNTJGNC4wJTJCQ2hyb21lJTI1MkY2Mi4wLjMyMDIuNzMlMkJNb2JpbGUlMkJTYWZhcmklMjUyRjUzNy4zNiZvcz0wJm9zdj0yMyZhcHB2PTEuMS4wJmNhcnJpZXI9MSZjb25uPTQmaXA9MTkyLjE2OC4wLjEwNCZicmFuZD1ub2tpYSZtb2RlbD1uNzAmdXVpZD04NjUxNTAwMzIzMjM0MzUmcHc9NzIwJnBoPTEyODA=&token=dcb496cda2c0666808941009ee3df9b5&__ABZMX__=&__ABZMY__=&__OFFSET_X__=&OFFSET_Y__=&EVENT_TIME_START__=&__EVENT_TIME_END__="]
         * adct : 1
         * clickurl : http://www.adinall.com/
         */

        private String imgurl;
        private int admt;
        private String adm;//html 样式广告，admt 为 4 时存在
        private int adct;
        private String clickurl;
        private List<String> thclkurl;
        private List<String> imgtracking;

        public String getAdm() {
            return adm;
        }

        public void setAdm(String adm) {
            this.adm = adm;
        }

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public int getAdmt() {
            return admt;
        }

        public void setAdmt(int admt) {
            this.admt = admt;
        }

        public int getAdct() {
            return adct;
        }

        public void setAdct(int adct) {
            this.adct = adct;
        }

        public String getClickurl() {
            return clickurl;
        }

        public void setClickurl(String clickurl) {
            this.clickurl = clickurl;
        }

        public List<String> getThclkurl() {
            return thclkurl;
        }

        public void setThclkurl(List<String> thclkurl) {
            this.thclkurl = thclkurl;
        }

        public List<String> getImgtracking() {
            return imgtracking;
        }

        public void setImgtracking(List<String> imgtracking) {
            this.imgtracking = imgtracking;
        }
    }
}
