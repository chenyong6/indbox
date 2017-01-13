package xstream.converter.modle.yunwei;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("FilePathes")
public class FilePathes {
	//URL地址(不超过1000个英文字符)
	@XStreamImplicit
	private List<FilePath>  FilePaths;

	public List<FilePath> getFilePaths() {
		return FilePaths;
	}

	public void setFilePath(List<FilePath> filePaths) {
		FilePaths = filePaths;
	}
}
