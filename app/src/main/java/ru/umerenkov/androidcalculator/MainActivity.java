package ru.umerenkov.androidcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void buttonClick(View view)
    {
        TextView t = (TextView) findViewById(R.id.console);
        CharSequence ttext=t.getText();
        boolean hasOperator = ttext.toString().contains("+") || ttext.toString().contains("-") || ttext.toString().contains("*") || ttext.toString().contains("/")|| ttext.toString().contains("%");
        boolean hasResult=ttext.toString().contains("=");
        switch(view.getId())
        {
            case R.id.button1:
                if (hasResult) t.setText("1");
                else t.append("1");
                break;

            case R.id.button2:
                if (hasResult) t.setText("2");
                else t.append("2");
                break;

            case R.id.button3:
                if (hasResult) t.setText("3");
                else t.append("3");
                break;

            case R.id.button4:
                if (hasResult) t.setText("4");
                else t.append("4");
                break;

            case R.id.button5:
                if (hasResult) t.setText("5");
                else t.append("5");
                break;

            case R.id.button6:
                if (hasResult) t.setText("6");
                else t.append("6");
                break;

            case R.id.button7:
                if (hasResult) t.setText("7");
                else t.append("7");
                break;

            case R.id.button8:
                if (hasResult) t.setText("8");
                else t.append("8");
                break;

            case R.id.button9:
                if (hasResult) t.setText("9");
                else t.append("9");
                break;

            case R.id.button0:
                if (hasResult) t.setText("0");
                else t.append("0");
                break;

            case R.id.buttondivide:
                if (ttext.length()>0 && Character.isDigit(ttext.charAt(ttext.length()-1)) && !hasOperator)
                 t.append("/");
                break;

            case R.id.buttonmultiply:
                if (ttext.length()>0 && Character.isDigit(ttext.charAt(ttext.length()-1)) && !hasOperator)
                t.append("*");
                break;

            case R.id.buttonplus:
                if (ttext.length()>0 && Character.isDigit(ttext.charAt(ttext.length()-1)) && !hasOperator)
                t.append("+");
                break;

            case R.id.buttonminus:
                if (ttext.length()>0 && Character.isDigit(ttext.charAt(ttext.length()-1)) && !hasOperator)
                t.append("-");
                break;

            case R.id.buttonmod:
                if (ttext.length()>0 && Character.isDigit(ttext.charAt(ttext.length()-1)) && !hasOperator)
                t.append("%");
                break;

            case R.id.buttonequals:
                if (ttext.length()>0 && Character.isDigit(ttext.charAt(ttext.length()-1)) && hasOperator)

                {
                    char operator=' ';
                    int firstOp;
                    int secondOp;

                    if (ttext.toString().contains("+")) operator='+';
                    else if (ttext.toString().contains("-")) operator='-';
                    else if (ttext.toString().contains("*")) operator='*';
                    else if (ttext.toString().contains("/")) operator='/';
                    else if (ttext.toString().contains("%")) operator='%';

                    firstOp=Integer.parseInt(ttext.toString().substring(0,ttext.toString().indexOf(operator)));
                    secondOp=Integer.parseInt(ttext.toString().substring(ttext.toString().indexOf(operator)+1,ttext.length()));

                    switch (operator)
                    {
                        case '+':
                            t.append("="+(firstOp+secondOp));
                        break;

                        case '-':
                        t.append("="+(firstOp-secondOp));
                        break;

                        case '*':
                        t.append("="+(firstOp*secondOp));
                        break;

                        case '/':
                        if (secondOp!=0)
                        t.append("="+((float)firstOp/secondOp));
                        else t.append("=division by zero error");
                        break;

                        case '%':
                        t.append("="+(firstOp%secondOp));
                        break;

                        default:
                            t.setText("ERR");
                    }

                }

                break;
        }
    }


}
