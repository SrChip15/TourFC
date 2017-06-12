package com.example.android.tourfc;

class AttractionDetails {

	//TODO: add member hashtags (String type data describing the activity type ex: hiking, outdoors)

	/**
	 * Image resource ID for the image file associated with the attraction
	 */
	private int mImageResourceId;

	/** Title of the attraction */
	private String mTitle;

	/** Brief description of the attraction */
	private String mDescription;

	/**
	 * Create data object that holds all the details of an attraction including an image resource
	 * for the attraction
	 *
	 * @param mImageResourceId an integer value for the image resource ID
	 * @param mTitle           a String value for the name of the attraction
	 * @param mDescription     a String value for a brief description of the attraction
	 */
	AttractionDetails(int mImageResourceId, String mTitle, String mDescription) {
		this.mImageResourceId = mImageResourceId;
		this.mTitle = mTitle;
		this.mDescription = mDescription;
	}

	/**
	 * Return the image file's unique ID
	 *
	 * @return the ID as an integer value
	 */
	int getImageResourceId() {
		return mImageResourceId;
	}

	/**
	 * Get the name of the attraction
	 *
	 * @return the name of the attraction as a String
	 */
	String getTitle() {
		return mTitle;
	}

	/**
	 * Get the description of the attraction
	 *
	 * @return brief description of the attraction as a String
	 */
	String getDescription() {
		return mDescription;
	}
}