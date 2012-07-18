package main.guessNumber;

public class Generate4DigitAnswer implements GenerateAnswer {

	@Override
	public String generateRadom() {
		String str = "";
		for(int i=0;i<4;i++){
			str = getRandom(str);
		}
		return str;
	}
	
	
	private String getRandom(String str){
		String newStr = str+ this.getRandomNumber(); 
		if(GuessNumberValidate.isDup(newStr)){
			return getRandom(str);
		}
		return newStr;
	}
	
	protected int getRandomNumber(){
		return (int)(Math.random()*10);
	}
}
