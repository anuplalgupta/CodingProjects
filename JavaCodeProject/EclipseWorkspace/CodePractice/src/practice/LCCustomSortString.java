package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


class CustomSortString {
	public String customSortString(String S, String T) {
		Map<Character,Integer> sIndexMap = new HashMap<>();

		for(int i =0;i<S.length();i++){
			sIndexMap.put(S.charAt(i),i);
		}

		Character[] tChars = new Character[T.length()];
		for(int i =0;i<T.length();i++){
			tChars[i] = T.charAt(i);
		}


		Arrays.sort(tChars, new Comparator<Character>(){
			@Override
			public int compare(Character c1, Character c2){
				return Integer.compare(sIndexMap.getOrDefault(c1,Integer.MAX_VALUE),sIndexMap.getOrDefault(c2,Integer.MAX_VALUE));
			}
		});
		char[] tcarr = new char[T.length()];
		for(int i =0;i<T.length();i++){
			tcarr[i] = tChars[i].charValue();
		}
		return String.valueOf(tcarr);
	}
}
public class LCCustomSortString
{
	public static void main(String[] args){
		CustomSortString customSortString = new CustomSortString();
		System.out.println(customSortString.customSortString("cba", "abcd"));
	}

}
