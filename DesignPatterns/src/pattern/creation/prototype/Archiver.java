package pattern.creation.prototype;

import java.io.File;

interface Archiver {

	void archive(File file);
	Archiver clone()throws CloneNotSupportedException;
}
