package me.guptahitesh.mynotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

public class NoteDetails extends AppCompatActivity {

    private TextView mTitleOfNoteDetail, mContentOfNoteDetail;
    FloatingActionButton mGotoEditNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notedetails);

        mTitleOfNoteDetail = findViewById(R.id.titleOfNoteDetail);
        mContentOfNoteDetail = findViewById(R.id.contentOfNoteDetail);
        mGotoEditNote = findViewById(R.id.gotoEditNote);
        Toolbar toolbar = findViewById(R.id.toolbarOfNoteDetail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent data = getIntent();

        mGotoEditNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EditNoteActivity.class);
                intent.putExtra("title", data.getStringExtra("title"));
                intent.putExtra("content", data.getStringExtra("content"));
                intent.putExtra("noteId", data.getStringExtra("noteId"));
                v.getContext().startActivity(intent);
            }
        });
        mTitleOfNoteDetail.setText(data.getStringExtra("title"));
        mContentOfNoteDetail.setText(data.getStringExtra("content"));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(NoteDetails.this, notes.class));
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            startActivity(new Intent(NoteDetails.this, notes.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}