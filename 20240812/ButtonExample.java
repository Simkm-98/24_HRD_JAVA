package day05;
import java.awt.*; // abstract window toolkit

import day05.Button.ClickListener;

class Button {
	
	public static interface ClickListener {
		void onClick();
	}
	
	private ClickListener clickListener;
	
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	
	public void click() {
		this.clickListener.onClick();
	}

}

public class ButtonExample {

	public static void main(String[] args) {
		
		Button btnOk = new Button();
		
		class OkListener implements Button.ClickListener {

			@Override
			public void onClick() {
				System.out.println("Ok 버튼을 클릭했습니다.");
			}
		}
		
		btnOk.setClickListener(new OkListener());
		
		btnOk.click();
		
		
		Button btnCancel = new Button();
		
		class CancelListener implements Button.ClickListener {

			@Override
			public void onClick() {
				System.out.println("Cancel 버튼을 클릭했습니다.");
			}	
		}
		
		btnCancel.setClickListener(new CancelListener());
		
		btnCancel.click();
	}
}
