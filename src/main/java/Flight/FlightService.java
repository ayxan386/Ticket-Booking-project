package Flight;
import User.User;

public class FlightService  {

  private FlightDAO flightDAO;

  public FlightService(FlightDAO flightDAO) {
    this.flightDAO = flightDAO;
  }

  public FlightService() {

  }
  public boolean smartAdd(Flight data) {
    if (flightDAO.contains(data)) return false;
    flightDAO.add(data);
    return true;
  }

  public boolean smartRemove(Flight data) {
    if (flightDAO.contains(data)) {
      flightDAO.remove(data.getId());
      return true;
    }
    return false;
  }

  public void eraseData() {
    flightDAO.eraseData();
  }

  public Flight get(String id) {
    return flightDAO.get(id);
  }

// public Flight getALLData() {
//        return flightDAO.getAllData();
//    }


  public Flight findFromTo(String form, String to) {
    return flightDAO.findFromTo(form,to);
  }


}