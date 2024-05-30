import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons=new JButton[12];
    JButton[] functionButtons=new JButton[11];
    JButton addButton,subButton,mulButton,divButton,sqrButton,invButton;
    JButton decButton,equButton,delButton,negButton,clrButton;
    JPanel panel;
    Font myFont=new Font("Ink Free",Font.BOLD,25);
    double num1=0,num2=0,num3=0,num4=0,num5=0,result=0;
    char operator;

    Main()
    {
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,440);
        frame.setLayout(null);
        textfield=new JTextField();
        textfield.setBounds(50,25,500,50);
        textfield.setFont(myFont);
        textfield.setForeground(Color.RED);
        textfield.setBackground(Color.LIGHT_GRAY);
        textfield.setEditable(false);

        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        equButton=new JButton("=");
        delButton=new JButton("DEL");
        clrButton=new JButton("AC");
        negButton=new JButton("NEG(-)");
        sqrButton=new JButton("X^2");
        invButton=new JButton("x^-1");

        functionButtons[0]=addButton;
        functionButtons[1]=subButton;
        functionButtons[2]=mulButton;
        functionButtons[3]=divButton;
        functionButtons[4]=decButton;
        functionButtons[5]=equButton;
        functionButtons[6]=delButton;
        functionButtons[7]=clrButton;
        functionButtons[8]=negButton;
        functionButtons[9]=sqrButton;
        functionButtons[10]=invButton;

        for(int i=0;i<11;i++)
        {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);

        }

        for(int i=0;i<10;i++)
        {
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);

        }

        negButton.setBounds(50,310,170,50);
        delButton.setBounds(215,310,170,50);
        clrButton.setBounds(380,310,170,50);

        panel=new JPanel();
        panel.setBounds(50,100,500,200);
        panel.setLayout(new GridLayout(3,6,3,3));
        panel.setBackground(Color.RED);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(divButton);

        panel.add(numberButtons[6]);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(numberButtons[0]);
        panel.add(mulButton);

        panel.add(decButton);
        panel.add(invButton);
        panel.add(sqrButton);
        panel.add(subButton);
        panel.add(addButton);
        panel.add(equButton);


        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
       Main calc=new Main();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        for(int i=0;i<10;i++ )
        {
            if(e.getSource()==numberButtons[i])
            {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton)
        {
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource()==addButton)
        {
            num1=Double.parseDouble(textfield.getText());
            operator='+';
            textfield.setText("");
        }
        if(e.getSource()==subButton)
        {
            num1=Double.parseDouble(textfield.getText());
            operator='-';
            textfield.setText("");
        }
        if(e.getSource()==mulButton)
        {
            num1=Double.parseDouble(textfield.getText());
            operator='*';
            textfield.setText("");
        }
        if(e.getSource()==divButton)
        {
            num1=Double.parseDouble(textfield.getText());
            operator='/';
            textfield.setText("");
        }
        if(e.getSource()==sqrButton)
        {
            num1=Double.parseDouble(textfield.getText());
            result=num1*num1;
            textfield.setText(String.valueOf(result));

        }
        if(e.getSource()==invButton)
        {
            num1=Double.parseDouble(textfield.getText());
            result=1/num1;
            textfield.setText(String.valueOf(result));
        }
        if(e.getSource()==equButton)
        {
            num2=Double.parseDouble(textfield.getText());
            switch(operator)
            {
                case'+':
                    result=num1+num2;
                    break;
                case'-':
                    result=num1-num2;
                    break;
                case'*':
                    result=num1*num2;
                    break;
                case'/':
                    result=num1/num2;
                    break;

            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==clrButton)
        {
            textfield.setText("");
        }
        if(e.getSource()==delButton)
        {
            String string=textfield.getText();
            textfield.setText("");
            for(int i=0;i<string.length()-1;i++)
            {
                textfield.setText(textfield.getText()+string.charAt(i));
            }


        }
        if(e.getSource()==negButton)
        {
            double temp=Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));

  }

}
}
