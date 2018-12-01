package printer.test.interpreter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LanguageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Language> languages;
    private OnClickListenerItime onClickListenerItime;

    public LanguageAdapter(List<Language> languages) {
        this.languages = languages;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.language_itme_meizhi, parent, false);
        return new LanguageViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof LanguageViewHolder) {
            LanguageViewHolder gankMeiZhiViewHolder = (LanguageViewHolder) holder;
            gankMeiZhiViewHolder.bindItem(languages.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return languages.size();
    }

    class LanguageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.guo)
        ImageView guo;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.imter)
        LinearLayout imter;

        public LanguageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindItem(final Language meizhi) {
            name.setText(meizhi.getLanguage());
            guo.setBackgroundResource(meizhi.getPic());
            imter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickListenerItime != null) {
                        onClickListenerItime.onItime(meizhi);
                    }
                }
            });
        }
    }

    public interface OnClickListenerItime {
        void onItime(Language language);
    }

    public void setOnClickListenerItime(OnClickListenerItime onClickListenerItime) {
        this.onClickListenerItime = onClickListenerItime;
    }
}
