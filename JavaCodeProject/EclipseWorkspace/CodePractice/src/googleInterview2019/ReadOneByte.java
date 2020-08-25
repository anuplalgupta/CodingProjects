package googleInterview2019;



//Looks better in retrospective
public class ReadOneByte {
	
	byte[] cache;
	Read4k reader;
	int pos = -1;
	int limit = 4096;
	
	public ReadOneByte(Read4k rdr) {
		this.reader = rdr;
		cache = new byte[4096];
	}
	//passing the Object of Byte class to contain the byte in retrun value is not negative
	//negative return value is the indication of failure
	public int read(Byte b) throws Exception{
		int res = 0;
		
		if(pos  == -1){

			if(limit < 4096){
				return -1;
			}

			int len =0;
			
			len = reader.read4kfromDisk(cache);
			
			if(len == 0){//reached endo file
				limit = 0;
				return -1;
			}		
			if(len < 4096){//last read no more reads allowed
					limit = len;
			}
			pos = 0;		
		}

		b = new Byte(cache[pos]);
		pos++;
		if(pos == limit){
			pos = -1;
		}
		
		return res;
	}

}

/*
Google round 7
	imagine an API which reads 4k and give a signature for that
	use that API to return one byte of data each time
*

//Please use this Google doc during your interview (your interviewer will see what you write here). To free your hands for typing, we recommend using a headset or speakerphone.
interface ReadStorage{
	//reads the 4k from a device and writes to buf
	//buf is initialized by the caller
	public int 
	read4k(byte[] buf) throws InvalidException,IOException, DeviceException;
}

Class reader implements ReadStorage{
 
public void read4k(byte[] buf){
}
}
class Result{
	Byte ans;
	Int errCode; //0 for success 
	String msg;
	//getter and setters
}


class ReadByte{
	Byte[] cache;
	Int pos = -1;
	Int limit = 4096; // to handle last read from device 
	ReadStorage rdr;
	public ReadByte(ReadStorage rdr){
		cache = new byte[4096];
		this.rdr = rdr;
	}
public Result read() throws Exception{
	Result res = new Res();

if(pos  == -1){

		if(limit < 4096){
			res.setErrCode(END_FILE_CODE);
			res.setMsg(�No more content to read�);
			return res
		}

		int len =0;
		try{
			len = rdr.read4k(cache);
		}catch(IOException e){
			res.setErrCode(IO_EXCEPTION_ERR_CODE);
			res.setMsg(e.msg);
			Return res;
}catch(DeviceNotFound e){
	res.setErrCode(DEVICE_EXCEPTION_ERR_CODE);
			res.setMsg(e.msg);
			Return res
}
if(len == 0){//reached endo file
	limit = 0;
	res.setErrCode(END_FILE_CODE);
			res.setMsg(�No more content to read�);
			return res
		}
		if(len < 4096){//last read no more reads allowed
			Limit = len;
		}
Pos = 0;		
	)

	res.setAns(cache[pos]);
	pos++;
	if(pos == limit){
		Pos = -1;
	}
}
}
*/





