import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

//주문할 수 있는 창이다.
public class JPanel02 extends JPanel { //2번째 패널
	JButton[] MBtn = new JButton[5];
	String[] menu = {
			"아메리카노", "카페모카", "카페라떼","카푸치노","카라멜 마끼야또","바닐라라떼","에스프레소"};
	
	
	int[] price = {10000,11000,12000,10000,13000, 11000, 9000}; //가격 배열
	JTextField tf = new JTextField(30);    //가격과 결제되었다라는 내용 나오는 부분
	JButton[] SBtn = new JButton[3];       //
	String[] Str = {"선택취소","전체취소","결제하기"};
	String [] ColName = {"메뉴","수량","가격"};
	String [][] Data ;
	int count =1;
	DefaultTableModel model = new DefaultTableModel(Data,ColName);
	JTable table = new JTable(model);

	
	class Screen extends JPanel{
		Screen(){
			setBackground(Color.darkGray);
			DefaultTableModel m = (DefaultTableModel)table.getModel();
			table.setRowHeight(50);
			table.getTableHeader().setFont(new Font("맑은고딕", Font.BOLD, 15));
			add(new JScrollPane(table));
		}
	}
	
	class MenuBtn extends JPanel{
		MenuBtn(){
	
			setLayout(new GridLayout(3, 3, 3, 3));	 //버튼 레이아웃
			setBackground(Color.darkGray); 			//레이아웃 배경색
			

			for(int i=0;i<MBtn.length;i++) {
				MBtn[i]= new JButton(menu[i]);
				add(MBtn[i]);
			}
		}

	}
	
	class StrBtn extends JPanel{
		StrBtn(){
			setBackground(Color.darkGray);
			setLayout(new GridLayout(1,4,3,3));
			
			for(int i=0;i<Str.length;i++) {
				SBtn[i]= new JButton(Str[i]);
				add(SBtn[i]);
			}
		}
	}
	
	public JPanel02() {
		setLayout(null);
		setBackground(Color.darkGray);
		MenuBtn mbtn = new MenuBtn();
		StrBtn sbtn = new StrBtn();
		Screen sc = new Screen();
		
		//금액란
		tf.setSize(450, 70);
		tf.setLocation(50, 480);
		add(tf);
		
		sc.setSize(500, 500);
		sc.setLocation(25, 20);
		add(sc);
		
		mbtn.setSize(400, 430);
		mbtn.setLocation(530, 23);
		add(mbtn);
		
		sbtn.setSize(400, 70);
		sbtn.setLocation(530, 480);
		add(sbtn);
		
		//메뉴추가
		for(int i=0;i<MBtn.length;i++) {
			final int index =i;
			MBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton MBtn = (JButton)e.getSource();
					DefaultTableModel m = (DefaultTableModel)table.getModel();
					m.addRow(new Object[]{menu[index],count,price[index]});
				}
			});
		}

		
			//선택취소
		SBtn[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				
				m.removeRow(table.getSelectedRow());
			}
		});
		
		
		//전체취소
		SBtn[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				DefaultTableModel m = (DefaultTableModel)table.getModel();
				
				m.setRowCount(0);
				tf.setText(String.valueOf(""));
			}
		});
		
		//결제버튼
		SBtn[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton MBtn = (JButton)e.getSource();
				int rowCont = table.getRowCount();
				int sum =0;
				for(int i=0;i<rowCont;i++) {
					sum += (int)table.getValueAt(i, 2);
				}
				tf.setText(String.valueOf(" 총 금액 : "+sum + "     "+ "주문해주셔서 감사합니다"));
				tf.setFont(new Font("맑은고딕", Font.BOLD, 20));
			}
		});
	}
	//2번째 패널 창에서 다시 첫번째 창을 불러오지 않기 때문에 이 코드는 주석처리를 한다.
	//class MyActionListener implements ActionListener{
	//@Override
	//public void actionPerformed(ActionEvent e){
	//  win.change("panel01");
}
