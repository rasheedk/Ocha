package ocha.audioapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import ocha.audioapp.models.AudioCategory;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db ;
    List<AudioCategory> categories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseFirestore.getInstance();
        getAllCategories();
        Log.d("OCHA", "");
    }

    private void getAllCategories() {

        db.collection(AppConstants.CATEGORIES)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                AudioCategory data = document.toObject(AudioCategory.class);
                                Log.d("OCHA", document.getId() + " => " + document.getData());
                                categories.add(data);
                            }
                        } else {
                            Log.w("OCHA", "Error getting documents.", task.getException());
                        }
                    }
                });

    }
}
