package com.alticeacademy.lost.firebase;

import android.util.Log;

import com.alticeacademy.lost.BaseEntity;
import com.alticeacademy.lost.Post;
import com.alticeacademy.lost.interfases.LoadModelable;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseHelper {


    public static void getTable(final String node, final Class entity, final LoadModelable listener){
        DatabaseReference db  = FirebaseDatabase.getInstance().getReference().child(node);
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listener.onStartLoading(node);
                List<Post> result = new ArrayList<>();
                for (DataSnapshot noteSnapshot: dataSnapshot.getChildren()){
                    Post model = (Post) noteSnapshot.getValue(entity);
                    // model.saveModel();
                    result.add(model);
                }
                listener.onFinished(result,node);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("FirebaseHelper", databaseError.getMessage());
            }
        });

    }
}
