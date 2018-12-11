package printer.test.interpreter;


import java.util.List;

import printer.test.interpreter.base.BaseView;

public interface MainView extends BaseView {
    /**
     * 要展示的数据
     *
     * @param context 要展示内容
     * @param isPic   是否是图片
     */
    void getShowText(String context, boolean isPic, List<String> thclkurl, List<String> imgtracking);

    /**
     * 添加请求总次数
     *
     * @param number
     */
    void addResNumber(int number);

    /**
     * 添加请求成功次数
     *
     * @param number
     */
    void addSuccessNumber(int number, List<String> imgtracking, List<String> thclkurl);

    /**
     * 点击上报的总次数
     *
     * @param number
     */
    void clickRequestFunAll(int number);

    /**
     * 点击上报成功次数
     *
     * @param number
     */
    void clickRequestFunSuccess(int number);

    /**
     * 曝光上报次数
     *
     * @param number
     */
    void exposureAppearAll(int number);

    /**
     * 曝光上报成功次数
     *
     * @param number
     */
    void exposureAppearSuccess(int number);
}
