
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegExExample {
	
	
static Function<String, String> funcEmpToString= (String str)-> {
	String modifiedString="";
	System.out.println("String to pe parsed  "+str);
	if(str.contains("_.[Document.Id]")){
		 String [] strArr=str.split("_");
		 modifiedString="meta("+strArr[0]+"_).id";
		 if(str.contains("_.[Document.Id],"))
			 modifiedString="meta("+strArr[0]+"_).id,";
		 return modifiedString;
	}
	else{
		return str;
	}
	};


public static void main(String[] args) {
	String mainStr="select subject_.[Document.Id], fozzxx_.[Document.Id],subject_.id as id4_, subject_.name as name4_, cat_.[Document.Id] from Subject subject_ where course_.[Document.Id]=? and doc=? and dog_.[Document.Id]=?";
	List<String> strList=Arrays.asList(mainStr.split("\\s+|[\\=]")).stream().map(funcEmpToString).collect(Collectors.toList());
	String result = String.join(" ", strList);
	if(result.contains(" ?")){
		result=result.replaceAll("\\?", "\\=\\$");
	}
	/*int counter=0;
	StringBuilder sb=new StringBuilder();
	for(int i=0;i<result.length();i++){
		if( result.charAt(i) == '$' ) {
	        counter++;
	    }
	}
	
	String resultquery="";
	int startIndex=result.indexOf(result);
	for(int j=1;j<=counter;j++){
	for(int i=startIndex;i<result.length();i++){
		int index=result.charAt('$');
		resultquery=replaceCharAt(result,index,'$',startIndex,j);
		startIndex=index;
	}
	}
	
	System.out.println("Result "+result);*/
	System.out.println("Result "+result);
}

public static String replaceCharAt(String s, int pos, char c,int start,int counter) {
	
	return null;
  }

}
