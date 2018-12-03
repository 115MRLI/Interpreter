package printer.test.interpreter.base;

/**
 */
public interface BasePresenter<V extends BaseView> {

    void attachView(V baseView);

    void detachView();
}
