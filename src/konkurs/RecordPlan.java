package konkurs;

import java.io.Serializable;

public class RecordPlan implements Serializable{
		private String hour, valueD1, valueD2, valueD3, valueD4, valueD5;
		
		public RecordPlan(){
			this.hour = "-";
			this.valueD1 = "-";
			this.valueD2 = "-";
			this.valueD3 = "-";
			this.valueD4 = "-";
			this.valueD5 = "-";
		}
		
		public RecordPlan(String h, String d1, String d2, String d3, String d4, String d5){
			this.hour = h;
			this.valueD1 = d1;
			this.valueD2 = d2; 
			this.valueD3 = d3;
			this.valueD4 = d4;
			this.valueD5 = d5;
		}

		public String getHour() {
			return hour;
		}

		public void setHour(String hour) {
			this.hour = hour;
		}

		public String getValueD1() {
			return valueD1;
		}

		public void setValueD1(String valueD1) {
			this.valueD1 = valueD1;
		}

		public String getValueD2() {
			return valueD2;
		}

		public void setValueD2(String valueD2) {
			this.valueD2 = valueD2;
		}

		public String getValueD3() {
			return valueD3;
		}

		public void setValueD3(String valueD3) {
			this.valueD3 = valueD3;
		}

		public String getValueD4() {
			return valueD4;
		}

		public void setValueD4(String valueD4) {
			this.valueD4 = valueD4;
		}

		public String getValueD5() {
			return valueD5;
		}

		public void setValueD5(String valueD5) {
			this.valueD5 = valueD5;
		}
}


//package konkurs;
//
//import java.io.Serializable;
//
//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;
//
//public class RecordPlan implements Serializable{
//		private SimpleStringProperty hour, valueD1, valueD2, valueD3, valueD4, valueD5;
//		
//		public RecordPlan(){
//			this.hour = new SimpleStringProperty("-");
//			this.valueD1 = new SimpleStringProperty("-");
//			this.valueD2 = new SimpleStringProperty("-");
//			this.valueD3 = new SimpleStringProperty("-");
//			this.valueD4 = new SimpleStringProperty("-");
//			this.valueD5 = new SimpleStringProperty("-");
//		}
//		
//		public RecordPlan(String h, String d1, String d2, String d3, String d4, String d5){
//			this.hour = new SimpleStringProperty(h);
//			this.valueD1 = new SimpleStringProperty(d1);
//			this.valueD2 = new SimpleStringProperty(d2); 
//			this.valueD3 = new SimpleStringProperty(d3);
//			this.valueD4 = new SimpleStringProperty(d4);
//			this.valueD5 = new SimpleStringProperty(d5);
//		}
//
//		public String getHour() {
//			return hour.get();
//		}
//
//		public void setHour(String hour) {
//			this.hour = new SimpleStringProperty(hour);
//		}
//
//		public String getValueD1() {
//			return valueD1.get();
//		}
//
//		public void setValueD1(String valueD1) {
//			this.valueD1 = new SimpleStringProperty(valueD1);
//		}
//
//		public String getValueD2() {
//			return valueD2.get();
//		}
//
//		public void setValueD2(String valueD2) {
//			this.valueD2 = new SimpleStringProperty(valueD2);
//		}
//
//		public String getValueD3() {
//			return valueD3.get();
//		}
//
//		public void setValueD3(String valueD3) {
//			this.valueD3 = new SimpleStringProperty(valueD3);
//		}
//
//		public String getValueD4() {
//			return valueD4.get();
//		}
//
//		public void setValueD4(String valueD4) {
//			this.valueD4 = new SimpleStringProperty(valueD4);
//		}
//
//		public String getValueD5() {
//			return valueD5.get();
//		}
//
//		public void setValueD5(String valueD5) {
//			this.valueD5 = new SimpleStringProperty(valueD5);
//		}
//
//		
//		
//}
