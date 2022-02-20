package clock;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {

	Calendar calendar;
	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;
	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;
	String time;
	String day;
	String date;

	MyFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("My Clock Program");
		this.setLayout(new FlowLayout());
		this.setSize(150, 140);
		this.setResizable(true);
		this.setVisible(true);

		timeFormat = new SimpleDateFormat("HH:mm:ss");
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dayFormat = new SimpleDateFormat("EEEE");
		
		timeLabel = new JLabel();
		timeLabel.setText(time);
		timeLabel.setFont(new Font("plain", Font.PLAIN, 50));
		timeLabel.setForeground(new Color(0x00FF00));
		timeLabel.setBackground(Color.black);
		timeLabel.setOpaque(true);

		dayLabel = new JLabel();
		timeLabel.setFont(new Font("plain", Font.PLAIN, 35));

		dateLabel = new JLabel();
		timeLabel.setFont(new Font("plain", Font.PLAIN, 25));
		
		this.add(timeLabel);
		this.add(dayLabel);
		this.add(dateLabel);
		this.setVisible(true);

		setTime();

	}

	public void setTime() {
		while (true) {
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);

			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
