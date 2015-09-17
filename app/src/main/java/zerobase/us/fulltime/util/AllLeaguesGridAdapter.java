package zerobase.us.fulltime.util;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import zerobase.us.fulltime.R;
import zerobase.us.fulltime.model.Leagues;

/**
 * Created by arvindchellapondy on 9/14/15.
 */
public class AllLeaguesGridAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Leagues> leagues;
    private LayoutInflater mInflater;
    private int[] colors;
    private int lastPosition=-1;

    public AllLeaguesGridAdapter(Context context){
        this.context = context;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        colors = context.getResources().getIntArray(R.array.league_material_colors_array);
    }

    @Override
    public int getCount() {
        return leagues.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.league_grid_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


//        Animation animation = AnimationUtils.loadAnimation(context, (position > lastPosition) ? R.anim.slide_in_left : R.anim.slide_out_left);

//        if(position==0){
//             animation = AnimationUtils.loadAnimation(context, (position > lastPosition) ? R.anim.slide_in_left : R.anim.slide_out_left);
//
//        }else{
//             animation = AnimationUtils.loadAnimation(context, (position > lastPosition) ? R.anim.slide_in_right : R.anim.slide_out_right);
//
//        }
//        convertView.startAnimation(animation);
//        lastPosition = position;

        viewHolder.leagueName.setBackgroundColor(colors[position]);
        viewHolder.leagueName.setText(leagues.get(position).getLeagueName());

        Picasso.with(context)
                .load(leagues.get(position).getLeagueLogo())
                .centerInside().fit()
                .into(viewHolder.leagueLogo);

        return convertView;
    }

    static class ViewHolder {

        @Bind(R.id.league_logo_image_view)
        SquareImageView leagueLogo;

        @Bind(R.id.league_logo_text_view)
        TextView leagueName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

    }

    public void addLeagues(ArrayList<Leagues> leagues){
        this.leagues = leagues;
        notifyDataSetChanged();
    }
}
