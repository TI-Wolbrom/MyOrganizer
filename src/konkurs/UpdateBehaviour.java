// Created by Patryk Tyliba [2017]

package konkurs;

public interface UpdateBehaviour {
	public void onUpdateNothingToUpdate();
	public void onUpdateStarted();
	public void onUpdateComplete();
	public void onUpdateError();
	public void onUpdateConnectionError();
}
