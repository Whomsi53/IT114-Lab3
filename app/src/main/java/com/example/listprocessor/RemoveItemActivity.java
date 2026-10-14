
package com.example.listprocessor;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RemoveItemActivity extends AppCompatActivity {

    @Inject
    ItemList the_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_item);

        EditText positionInput =
                findViewById(R.id.remove_item_position);

        Button removeButton =
                findViewById(R.id.remove_item_button);

        removeButton.setOnClickListener(v -> {
            try {
                int position = Integer.parseInt(
                        positionInput.getText().toString());

                the_list.remove(position);

                Toast.makeText(this, "Item removed.",
                        Toast.LENGTH_SHORT).show();

                finish();

            } catch (Exception e) {
                Toast.makeText(this,
                        "Invalid position. Please try again.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
