package com.example.android.tourfc;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class OdellActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Set layout for the activity
		setContentView(R.layout.attraction_detail_view);

		// Grab a handle on the card view for the detailed description of the attraction
		CardView cardView = (CardView) findViewById(R.id.detailed_description_card_widget);
		// Convert px to dips
		Resources r = getResources();
		int contentPadding = (int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP,
				8,
				r.getDisplayMetrics());
		// Set padding for detailed description within the card widget
		cardView.setContentPadding(contentPadding, contentPadding, contentPadding, contentPadding);

		// Grab a handle on the image view
		ImageView detailImageView = (ImageView) findViewById(R.id.attraction_detail_image_view);
		detailImageView.setImageResource(R.drawable.odell_brewing);

		// grab a handle on the text view
		TextView textView = (TextView) findViewById(R.id.attraction_detail_text_view);
		textView.setText(getString(R.string.odell_brewing_detailed_desc_card_text));

		// Grab a handle on the button view
		Button buttonView = (Button) findViewById(R.id.attraction_detail_button_view);
		buttonView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Parse the uri with the longitude and latitude
				// along with the label for the attraction
				Uri location = Uri
						.parse("geo:0,0?q=40.5894715,-105.0653706(Odell+Brewing+Company)");

				// Pass the parsed uri string to the method that creates map intent
				showMap(location);
			}
		});
	}

	/**
	 * Create map intent that takes in the location of the attraction as a {@link Uri}
	 *
	 * @param geoLocation an {@link Uri} for the longitude and latitude of the attraction
	 */
	public void showMap(Uri geoLocation) {
		// Initialize the map intent with an action and the geolocation parameter
		Intent mapIntent = new Intent(Intent.ACTION_VIEW, geoLocation);

		// Make the intent explicit by setting Google Maps package
		mapIntent.setPackage("com.google.android.apps.maps");

		// Check for suitable package that can handle the intent
		// Gracefully handles situations where the host system does not have the required package
		// to handle the intent
		if (mapIntent.resolveActivity(getPackageManager()) != null) {
			startActivity(mapIntent);
		}
	}
}
