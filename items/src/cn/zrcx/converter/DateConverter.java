package cn.zrcx.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DateConverter implements Converter<String, Date>{

	public Date convert(String source) {
		
		try
		{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			return sdf.parse(source);
	    } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	    }
			return null;
		
	}

}
