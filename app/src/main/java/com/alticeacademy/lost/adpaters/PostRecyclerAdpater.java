package com.alticeacademy.lost.adpaters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.alticeacademy.lost.Post;
import com.alticeacademy.lost.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class PostRecyclerAdpater extends RecyclerView.Adapter<PostRecyclerAdpater.MyPostRecycleViewHolder> {

    private final List<Post> posts;
    private final Context context;

    public PostRecyclerAdpater(Context context, List<Post> posts ) {
        this.posts = posts;
        this.context = context;
    }


    @NonNull
    @Override
    public MyPostRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        int layout = R.layout.card_view_post;

        View view = LayoutInflater.from(context).inflate(layout, viewGroup, false);
        MyPostRecycleViewHolder holder = new MyPostRecycleViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyPostRecycleViewHolder holder, int position) {
        Post myPost = posts.get(position);

        holder.userName.setText(myPost.getUserName());
        holder.lostName.setText(myPost.getLostName());
        holder.lostDescription.setText(myPost.getPostDescripcion());
        holder.postDate.setText(myPost.getPostDate());

        Glide.with(context)
                .load(myPost.getImageLostURL())
                .into(holder.lostImage);

        /*Glide.with(context)
                .load(myPost.getUserFaceURL())
                .into(holder.userFace);*/

       /* try{
            URL url = new URL(myItem.getImageUrl());
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            holder.imageView.setImageBitmap(bmp);

        }catch (Exception e){
            e.printStackTrace();
        }*/
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class MyPostRecycleViewHolder extends RecyclerView.ViewHolder {
        public ImageView userFace, lostImage;
        public  TextView userName, postDate, lostName, lostDescription;


        public MyPostRecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            userFace = itemView.findViewById(R.id.userFace);
            lostImage = itemView.findViewById(R.id.postImage);
            userName = itemView.findViewById(R.id.txtUserName);
            postDate = itemView.findViewById(R.id.txtPostDate);
            lostName = itemView.findViewById(R.id.txtLostName);
            lostDescription = itemView.findViewById(R.id.txtPostDescription);
        }
    }
}
