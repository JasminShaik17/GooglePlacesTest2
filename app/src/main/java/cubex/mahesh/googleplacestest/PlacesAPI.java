package cubex.mahesh.googleplacestest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlacesAPI {

    @GET("maps/api/place/nearbysearch/json?location=17.4375925,78.4490243&radius=1500&key=AIzaSyCmrO982oIl_BAMz_GLKehkKSwDS1whaHo")
    Call<Places> getPlaces(@Query("type") String type);

}
