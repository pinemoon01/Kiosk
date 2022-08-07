import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JPanel;

//주문하기 버튼이 있는 홈 화면이다.
public class JPanel01 extends JPanel { //첫번째 패널
	
	private JButton jButton1;
	
	private JPanelTest win;
	
	
	
	public JPanel01(JPanelTest win) {
		this.win = win;
		setLayout(null);
		setBackground(Color.darkGray);
	
		
	
		
		
		jButton1 = new JButton("주문하기");
		jButton1.setSize(100,50);
		jButton1.setLocation(200,200);
		add(jButton1);
		
		jButton1.addActionListener(new MyActionListener());
	}
	
	class MyActionListener implements ActionListener{
		//버튼 키 눌리면 패널 2번인 JPanel02 호출됨
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel02");
		}

	
	}
}

