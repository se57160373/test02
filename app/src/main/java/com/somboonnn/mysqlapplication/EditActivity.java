package com.somboonnn.mysqlapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        final TodoList editTodolist = (TodoList) getIntent().getSerializableExtra("editTodolist");

        final EditText editText = (EditText)findViewById(R.id.edit_editText);
        editText.setText(editTodolist.getTaskname());

        Button editBtn = (Button)findViewById(R.id.edit_button);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoList eTodoList = new TodoList();
                eTodoList.setTaskid(editTodolist.getTaskid());
                eTodoList.setTaskname(String.valueOf(editText.getText()));

                TodoListDAO todoListDAO = new TodoListDAO(getApplicationContext());
                todoListDAO.open();
                todoListDAO.update(eTodoList);
                todoListDAO.close();

                finish();
            }
        });
    }
}
