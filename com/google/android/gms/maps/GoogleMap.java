package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.C0251b;
import com.google.android.gms.dynamic.C0916c;
import com.google.android.gms.internal.er;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.google.android.gms.maps.internal.C0372b.C0765a;
import com.google.android.gms.maps.internal.C0374d.C0769a;
import com.google.android.gms.maps.internal.C0375e.C0771a;
import com.google.android.gms.maps.internal.C0376f.C0773a;
import com.google.android.gms.maps.internal.C0377g;
import com.google.android.gms.maps.internal.C0378h.C0777a;
import com.google.android.gms.maps.internal.C0379i.C0779a;
import com.google.android.gms.maps.internal.C0380j.C0781a;
import com.google.android.gms.maps.internal.C0381k.C0783a;
import com.google.android.gms.maps.internal.C0382l.C0785a;
import com.google.android.gms.maps.internal.C0383m.C0787a;
import com.google.android.gms.maps.internal.C0384n.C0789a;
import com.google.android.gms.maps.internal.C0385o.C0791a;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.ILocationSourceDelegate.C0755a;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.C0400c;
import com.google.android.gms.maps.model.internal.C0401d;
import com.google.android.gms.maps.model.internal.C0403f;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate OK;
    private UiSettings OL;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.10 */
    class AnonymousClass10 extends C0773a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ OnInfoWindowClickListener OY;

        AnonymousClass10(GoogleMap googleMap, OnInfoWindowClickListener onInfoWindowClickListener) {
            this.ON = googleMap;
            this.OY = onInfoWindowClickListener;
        }

        public void m2811e(C0401d c0401d) {
            this.OY.onInfoWindowClick(new Marker(c0401d));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.11 */
    class AnonymousClass11 extends C0769a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ InfoWindowAdapter OZ;

        AnonymousClass11(GoogleMap googleMap, InfoWindowAdapter infoWindowAdapter) {
            this.ON = googleMap;
            this.OZ = infoWindowAdapter;
        }

        public C0251b m2812f(C0401d c0401d) {
            return C0916c.m2415h(this.OZ.getInfoWindow(new Marker(c0401d)));
        }

        public C0251b m2813g(C0401d c0401d) {
            return C0916c.m2415h(this.OZ.getInfoContents(new Marker(c0401d)));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.12 */
    class AnonymousClass12 extends C0789a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ OnMyLocationChangeListener Pa;

        AnonymousClass12(GoogleMap googleMap, OnMyLocationChangeListener onMyLocationChangeListener) {
            this.ON = googleMap;
            this.Pa = onMyLocationChangeListener;
        }

        public void m2814d(C0251b c0251b) {
            this.Pa.onMyLocationChange((Location) C0916c.m2414b(c0251b));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.1 */
    class C09951 extends C0755a {
        final /* synthetic */ LocationSource OM;
        final /* synthetic */ GoogleMap ON;

        /* renamed from: com.google.android.gms.maps.GoogleMap.1.1 */
        class C07431 implements OnLocationChangedListener {
            final /* synthetic */ C0377g OO;
            final /* synthetic */ C09951 OP;

            C07431(C09951 c09951, C0377g c0377g) {
                this.OP = c09951;
                this.OO = c0377g;
            }

            public void onLocationChanged(Location location) {
                try {
                    this.OO.m1131g(C0916c.m2415h(location));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
        }

        C09951(GoogleMap googleMap, LocationSource locationSource) {
            this.ON = googleMap;
            this.OM = locationSource;
        }

        public void activate(C0377g listener) {
            this.OM.activate(new C07431(this, listener));
        }

        public void deactivate() {
            this.OM.deactivate();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.2 */
    class C09962 extends C0787a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ OnMyLocationButtonClickListener OQ;

        C09962(GoogleMap googleMap, OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
            this.ON = googleMap;
            this.OQ = onMyLocationButtonClickListener;
        }

        public boolean onMyLocationButtonClick() throws RemoteException {
            return this.OQ.onMyLocationButtonClick();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.3 */
    class C09973 extends C0779a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ OnMapLoadedCallback OR;

        C09973(GoogleMap googleMap, OnMapLoadedCallback onMapLoadedCallback) {
            this.ON = googleMap;
            this.OR = onMapLoadedCallback;
        }

        public void onMapLoaded() throws RemoteException {
            this.OR.onMapLoaded();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.4 */
    class C09984 extends C0791a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ SnapshotReadyCallback OS;

        C09984(GoogleMap googleMap, SnapshotReadyCallback snapshotReadyCallback) {
            this.ON = googleMap;
            this.OS = snapshotReadyCallback;
        }

        public void m2815c(C0251b c0251b) throws RemoteException {
            this.OS.onSnapshotReady((Bitmap) C0916c.m2414b(c0251b));
        }

        public void onSnapshotReady(Bitmap snapshot) throws RemoteException {
            this.OS.onSnapshotReady(snapshot);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.5 */
    class C09995 extends C0771a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ OnCameraChangeListener OT;

        C09995(GoogleMap googleMap, OnCameraChangeListener onCameraChangeListener) {
            this.ON = googleMap;
            this.OT = onCameraChangeListener;
        }

        public void onCameraChange(CameraPosition position) {
            this.OT.onCameraChange(position);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.6 */
    class C10006 extends C0777a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ OnMapClickListener OU;

        C10006(GoogleMap googleMap, OnMapClickListener onMapClickListener) {
            this.ON = googleMap;
            this.OU = onMapClickListener;
        }

        public void onMapClick(LatLng point) {
            this.OU.onMapClick(point);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.7 */
    class C10017 extends C0781a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ OnMapLongClickListener OV;

        C10017(GoogleMap googleMap, OnMapLongClickListener onMapLongClickListener) {
            this.ON = googleMap;
            this.OV = onMapLongClickListener;
        }

        public void onMapLongClick(LatLng point) {
            this.OV.onMapLongClick(point);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.8 */
    class C10028 extends C0783a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ OnMarkerClickListener OW;

        C10028(GoogleMap googleMap, OnMarkerClickListener onMarkerClickListener) {
            this.ON = googleMap;
            this.OW = onMarkerClickListener;
        }

        public boolean m2816a(C0401d c0401d) {
            return this.OW.onMarkerClick(new Marker(c0401d));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.9 */
    class C10039 extends C0785a {
        final /* synthetic */ GoogleMap ON;
        final /* synthetic */ OnMarkerDragListener OX;

        C10039(GoogleMap googleMap, OnMarkerDragListener onMarkerDragListener) {
            this.ON = googleMap;
            this.OX = onMarkerDragListener;
        }

        public void m2817b(C0401d c0401d) {
            this.OX.onMarkerDragStart(new Marker(c0401d));
        }

        public void m2818c(C0401d c0401d) {
            this.OX.onMarkerDragEnd(new Marker(c0401d));
        }

        public void m2819d(C0401d c0401d) {
            this.OX.onMarkerDrag(new Marker(c0401d));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.a */
    private static final class C1004a extends C0765a {
        private final CancelableCallback Pb;

        C1004a(CancelableCallback cancelableCallback) {
            this.Pb = cancelableCallback;
        }

        public void onCancel() {
            this.Pb.onCancel();
        }

        public void onFinish() {
            this.Pb.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate map) {
        this.OK = (IGoogleMapDelegate) er.m725f(map);
    }

    public final Circle addCircle(CircleOptions options) {
        try {
            return new Circle(this.OK.addCircle(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions options) {
        try {
            C0400c addGroundOverlay = this.OK.addGroundOverlay(options);
            return addGroundOverlay != null ? new GroundOverlay(addGroundOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions options) {
        try {
            C0401d addMarker = this.OK.addMarker(options);
            return addMarker != null ? new Marker(addMarker) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions options) {
        try {
            return new Polygon(this.OK.addPolygon(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions options) {
        try {
            return new Polyline(this.OK.addPolyline(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions options) {
        try {
            C0403f addTileOverlay = this.OK.addTileOverlay(options);
            return addTileOverlay != null ? new TileOverlay(addTileOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update) {
        try {
            this.OK.animateCamera(update.gK());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, int durationMs, CancelableCallback callback) {
        try {
            this.OK.animateCameraWithDurationAndCallback(update.gK(), durationMs, callback == null ? null : new C1004a(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, CancelableCallback callback) {
        try {
            this.OK.animateCameraWithCallback(update.gK(), callback == null ? null : new C1004a(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.OK.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    IGoogleMapDelegate gM() {
        return this.OK;
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.OK.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.OK.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.OK.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.OK.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.OK.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.OK.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.OL == null) {
                this.OL = new UiSettings(this.OK.getUiSettings());
            }
            return this.OL;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.OK.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.OK.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.OK.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.OK.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate update) {
        try {
            this.OK.moveCamera(update.gK());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBuildingsEnabled(boolean enabled) {
        try {
            this.OK.setBuildingsEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean enabled) {
        try {
            return this.OK.setIndoorEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter adapter) {
        if (adapter == null) {
            try {
                this.OK.setInfoWindowAdapter(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setInfoWindowAdapter(new AnonymousClass11(this, adapter));
    }

    public final void setLocationSource(LocationSource source) {
        if (source == null) {
            try {
                this.OK.setLocationSource(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setLocationSource(new C09951(this, source));
    }

    public final void setMapType(int type) {
        try {
            this.OK.setMapType(type);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean enabled) {
        try {
            this.OK.setMyLocationEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraChangeListener(OnCameraChangeListener listener) {
        if (listener == null) {
            try {
                this.OK.setOnCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setOnCameraChangeListener(new C09995(this, listener));
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener listener) {
        if (listener == null) {
            try {
                this.OK.setOnInfoWindowClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setOnInfoWindowClickListener(new AnonymousClass10(this, listener));
    }

    public final void setOnMapClickListener(OnMapClickListener listener) {
        if (listener == null) {
            try {
                this.OK.setOnMapClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setOnMapClickListener(new C10006(this, listener));
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback callback) {
        if (callback == null) {
            try {
                this.OK.setOnMapLoadedCallback(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setOnMapLoadedCallback(new C09973(this, callback));
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener listener) {
        if (listener == null) {
            try {
                this.OK.setOnMapLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setOnMapLongClickListener(new C10017(this, listener));
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener listener) {
        if (listener == null) {
            try {
                this.OK.setOnMarkerClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setOnMarkerClickListener(new C10028(this, listener));
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener listener) {
        if (listener == null) {
            try {
                this.OK.setOnMarkerDragListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setOnMarkerDragListener(new C10039(this, listener));
    }

    public final void setOnMyLocationButtonClickListener(OnMyLocationButtonClickListener listener) {
        if (listener == null) {
            try {
                this.OK.setOnMyLocationButtonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setOnMyLocationButtonClickListener(new C09962(this, listener));
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener listener) {
        if (listener == null) {
            try {
                this.OK.setOnMyLocationChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.OK.setOnMyLocationChangeListener(new AnonymousClass12(this, listener));
    }

    public final void setPadding(int left, int top, int right, int bottom) {
        try {
            this.OK.setPadding(left, top, right, bottom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean enabled) {
        try {
            this.OK.setTrafficEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback callback) {
        snapshot(callback, null);
    }

    public final void snapshot(SnapshotReadyCallback callback, Bitmap bitmap) {
        try {
            this.OK.snapshot(new C09984(this, callback), (C0916c) (bitmap != null ? C0916c.m2415h(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.OK.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
