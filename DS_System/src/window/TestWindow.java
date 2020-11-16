package window;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestWindow {

    public static void main(String[] args) {
    	DataManager.DM.initParameterofDistribution();
    	JFrame jf = new JFrame("����ģ����������");
    	WindowCreate(jf);
    }
    
    
    //��������
    public static void WindowCreate(JFrame jf) {
    	int[] index = {0};
        jf.setSize(450, 370);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        //�ֲ�����
        JLabel label = new JLabel("�ֲ����ͣ�");
        label.setBounds(0, 0, 100, 50);
        panel.add(label);
        //�ֲ�����
        JLabel sublabel = new JLabel("�ֲ����ƣ�");
        sublabel.setBounds(0, 60, 100, 50);
        panel.add(sublabel);
        //�����б�
        JLabel plabel = new JLabel("�����б�");
        plabel.setBounds(0, 110, 100, 50);
        panel.add(plabel);
        // ����һ�������б��
        final JComboBox<String> comboBox = new JComboBox<String>(DataManager.DM.listData);
        final JComboBox<String> comboBox_kindsOne = new JComboBox<String>(DataManager.DM.kindone);
        final JComboBox<String> comboBox_kindsTwo = new JComboBox<String>(DataManager.DM.kindtwo);
        // ����Ĭ��ѡ�е���Ŀ
        comboBox.setSelectedIndex(0);
        comboBox.setBounds(60, 15, 200, 30);
        comboBox_kindsOne.setBounds(60, 75, 200, 30);
        comboBox_kindsTwo.setBounds(60, 75, 200, 30);
        
        //�����������Զ����ı���
        JLabel pLabel = new JLabel("");
        pLabel.setBounds(60, 120, 400, 30);
        panel.add(pLabel);
        final JTextField textField = new JTextField(8);
        textField.setBounds(60, 160, 330, 30);
        panel.add(textField);
        
        JLabel warnLabel = new JLabel("��ȷ����������Ҫ��");
        warnLabel.setFont(new Font(null, Font.BOLD, 15));
        warnLabel.setBounds(60, 200, 400, 30);
        panel.add(warnLabel);
        
        JLabel numLabel = new JLabel("��������:");
        numLabel.setBounds(0, 235, 400, 30);
        panel.add(numLabel);
        
        final JTextField textField_Num = new JTextField(8);
        textField_Num.setBounds(60, 240, 330, 30);
        textField_Num.setFont(new Font(null, Font.PLAIN, 20));
        panel.add(textField_Num);
        // ����һ����ť��������ȡ�ı����е��ı�
        final JButton submit_btn = new JButton("�ύ");
        submit_btn.setFont(new Font(null, Font.PLAIN, 13));
        submit_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//�������������������ֲ����ʹ���GC
            	//����������
                try {
					GenerateController.GC.Generate(index[0], textField.getText(), textField_Num.getText());
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
            }
        });
        submit_btn.setBounds(60,280, 60, 30);
        panel.add(submit_btn); 
        final JButton exit_btn = new JButton("�˳�");
        exit_btn.setFont(new Font(null, Font.PLAIN, 13));
        exit_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//�������������������ֲ����ʹ���GC
            	//����������
                try {
					GenerateController.GC.Generate(index[0], textField.getText(), textField_Num.getText());
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
            }
        });
        exit_btn.setBounds(330,280, 60, 30);
        panel.add(exit_btn); 
        // ��ӵ��������
        panel.add(comboBox);
        panel.add(comboBox_kindsOne);
        comboBox_kindsOne.setVisible(false);
        panel.add(comboBox_kindsTwo);
        comboBox_kindsTwo.setVisible(false);
        
        // �����Ŀѡ��״̬�ı�ļ�����
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // ֻ����ѡ�е�״̬
                if (e.getStateChange() == ItemEvent.SELECTED) {
                	if(comboBox.getSelectedIndex() == 0) {
                    	comboBox_kindsOne.setVisible(false);
                    	comboBox_kindsTwo.setVisible(false);
                    }
                    if(comboBox.getSelectedIndex() == 1) {
                    	comboBox_kindsOne.setVisible(true);
                    	comboBox_kindsTwo.setVisible(false);
                    }
                    if(comboBox.getSelectedIndex() == 2) {
                    	comboBox_kindsTwo.setVisible(true);
                    	comboBox_kindsOne.setVisible(false);
                    }
                }
            }
        });
        
        comboBox_kindsOne.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					index[0] = comboBox_kindsOne.getSelectedIndex();
					System.out.println(DataManager.DM.map.get(index[0]));
					pLabel.setText(DataManager.DM.map.get(index[0]));
				}
			}
        });
        
        comboBox_kindsTwo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					index[0] = comboBox_kindsTwo.getSelectedIndex() + 7;
					pLabel.setText(DataManager.DM.map.get(index[0]));
				}
			}
        });
        jf.setContentPane(panel);
        jf.setVisible(true);
    }

}
