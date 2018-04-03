package algorithms;

import java.util.*;

class Time implements Comparable<Time>{
    Integer hr;
    Integer min;

    public Time(Integer hr, Integer min) {
        this.hr = hr;
        this.min = min;
    }

    public int compareTo(Time that) {
        if(this.hr.equals(that.hr))
            return this.min.compareTo(that.min);
        else
            return this.hr.compareTo(that.hr);
    }

    @Override
    public String toString() {
        return hr + ":" + min;
    }
}

public class NPlatforms {
    public static int countPlatforms(Time[] arrivals, Time[] departures, int N) {
        Arrays.sort(arrivals);
        Arrays.sort(departures);
        System.out.println("Arrrivals  : " + Arrays.toString(arrivals) + "\nDepartures : " + Arrays.toString(departures));

        int required = 0;
        int result = 0;
        int i=0,j=0;

        do {
            if(arrivals[i].compareTo(departures[j]) < 0) {
                required++;
                i++;
                if(required > result) {
                    result = required;
                }
            } else {
                required--;
                j++;
            }
        } while(i < N && j < N);
        return result;
    }

    public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        Time[] arrivals = new Time[N];
        Time[] departures = new Time[N];
        for(int i=0; i<N; i++) {
            String inTime = scanner.nextLine();
            String outTime = scanner.nextLine();
            arrivals[i] = new Time(Integer.parseInt(inTime.split(":")[0]), Integer.parseInt(inTime.split(":")[1]));
            departures[i] = new Time(Integer.parseInt(outTime.split(":")[0]), Integer.parseInt(outTime.split(":")[1]));
        }

        System.out.println(countPlatforms(arrivals, departures, N));
        /*Map<Time,Time> flights = new HashMap<Time, Time>();
        for(int i=0; i<N; i++) {
           String inTime = scanner.nextLine();
           String outTime = scanner.nextLine();
           flights.put(
                   new Time(Integer.parseInt(inTime.split(":")[0]), Integer.parseInt(inTime.split(":")[1])),
                   new Time(Integer.parseInt(outTime.split(":")[0]), Integer.parseInt(outTime.split(":")[1]))
           );
        }
        Iterator timeIterator = flights.entrySet().iterator();
        Time lastOutTime = null;
        int count = 0;
        while(timeIterator.hasNext()) {
            Map.Entry<Time, Time> nextFlight = (Map.Entry<Time, Time>) timeIterator.next();
            Time inTime = nextFlight.getKey();
            if(lastOutTime == null) {
                lastOutTime = nextFlight.getValue();
                continue;
            }
            if(inTime.compareTo(lastOutTime) < 0) {
                count++;
                lastOutTime = nextFlight.getValue();
            }
        }
        System.out.println(count+1);*/

        /*List<Flight> flights = new ArrayList<Flight>();
        for(int i=0; i<N; i++) {
            String inTime = scanner.nextLine();
            String outTime = scanner.nextLine();
            Flight flight = new Flight(
                new Time(Integer.parseInt(inTime.split(":")[0]), Integer.parseInt(inTime.split(":")[1])),
                new Time(Integer.parseInt(outTime.split(":")[0]), Integer.parseInt(outTime.split(":")[1]))
            );
            flights.add(flight);
        }

        Collections.sort(flights);

        Iterator<Flight> flightIterator = flights.iterator();
        Time lastOutTime = null;
        int count = 0;
        while(flightIterator.hasNext()) {
            Flight currentFlight = flightIterator.next();
            Time inTime = currentFlight.inTime;
            Time outTime = currentFlight.outTime;
            if(lastOutTime == null) {
                count++;
                lastOutTime = outTime;
                continue;
            }
            if(inTime.compareTo(lastOutTime) < 0) {
                count++;
                lastOutTime = outTime;
            }
        }
        System.out.println(count);*/
    }
}
