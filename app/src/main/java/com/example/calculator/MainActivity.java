package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    double firstnum;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button num7 = findViewById(R.id.num7);
        Button num4 = findViewById(R.id.num4);
        Button num1 = findViewById(R.id.num1);
        Button delete = findViewById(R.id.delete);
        Button on = findViewById(R.id.on);
        Button off = findViewById(R.id.off);
        Button num8 = findViewById(R.id.num8);
        Button num5 = findViewById(R.id.num5);
        Button num2 = findViewById(R.id.num2);
        Button num0 = findViewById(R.id.num0);
        Button ac = findViewById(R.id.ac);
        Button num9 = findViewById(R.id.num9);
        Button num6 = findViewById(R.id.num6);
        Button num3 = findViewById(R.id.num3);
        Button point = findViewById(R.id.point);
        Button div = findViewById(R.id.div);
        Button mul = findViewById(R.id.mul);
        Button min = findViewById(R.id.min);
        Button plus = findViewById(R.id.plus);
        Button equel = findViewById(R.id.equel);
        TextView screen = findViewById(R.id.screen);
        ac.setOnClickListener(view -> {
            firstnum = 0;
            screen.setText("0");});


        off.setOnClickListener(view -> screen.setVisibility(View.GONE));
        on.setOnClickListener(view -> {
            screen.setVisibility(View.VISIBLE);
            screen.setText("0");;
        });
        ArrayList<Button> nums = new ArrayList<>();
        nums.add(num7);
        nums.add(num4);
        nums.add(num1);


        nums.add(num8);
        nums.add(num5);
        nums.add(num2);
        nums.add(num0);

        nums.add(num9);
        nums.add(num6);
        nums.add(num3);
        nums.add(point);

        for (Button button : nums) {
            button.setOnClickListener(view -> {
                        if (!screen.getText().toString().equals("0")) {
                            screen.setText(screen.getText().toString() + button.getText().toString());
                        } else {
                            screen.setText(button.getText().toString());
                        }
                    }
            );
        }

        ArrayList<Button> opers = new ArrayList<>();
        opers.add(div);
        opers.add(mul);
        opers.add(min);
        opers.add(plus);
        opers.add(equel);
        for (Button button : opers) {
            button.setOnClickListener(view -> {
                firstnum = Double.parseDouble(screen.getText().toString());
                operation = button.getText().toString();
                screen.setText("0");
            });
        }
        delete.setOnClickListener(view -> {
            String num = screen.getText().toString();
            if (num.length() > 1) {
                screen.setText(num.substring(0, num.length() - 1));
            } else if (num.length()== 1 && !num.equals("0")) {
                screen.setText("0");

            }
        });
        point.setOnClickListener(
                view -> {
                    if (!screen.getText().toString().contains(".")) {
                        screen.setText(screen.getText().toString() + ".");
                    }
                }
        );
        equel.setOnClickListener(view -> {
            double secondNum = Double.parseDouble(screen.getText().toString());
            double result;
            switch (operation){
                case "/":
                    result= firstnum/secondNum;
                    break;
                    case "X":
                    result= firstnum*secondNum;
                    break;
                case "-":
                    result= firstnum-secondNum;
                    break;
                case "+":
                    result= firstnum+secondNum;
                    break;
                default:
                    result= firstnum+secondNum;
                    break;
            }
              screen.setText(String.valueOf(result));
            firstnum =result;
            operation="";
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;

                }
        );

    }
}
