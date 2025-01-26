package edu.asu.app;
/**
 * Rosie's Road Co. is a new local construction company. They are interested in
 * bidding on new roadway construction projects around the city. They've hired
 * you to help develop some software tools that they will use to determine
 * material needs and costs.
 * 
 * Road development is not only the asphalt you see. Water and power conduits 
 * must be installed at the same time, and we have to account for things like
 * labor costs and how long it will take to complete a particular road project.
 * 
 * The city is very regular grid, with one 4-way intersection at each mile of
 * road. When asking for a quote, the city sends out the number of linear miles
 * of road, and how many total lanes (1 to 8).
 * 
 * -The trucks hauling asphalt have a maximum capacity of 5 US tons (10,000 lbs)
 * -The standard road lane is 12 feet wide.
 * -Asphalt weighs 150 lbs per cubic foot
 * -Asphalt costs $250 per ton
 * -Power and water utilities are run under the road as part of all road
 *  projects
 * -Power conduit is available only in 20 ft. lengths - each length costs $350
 * -Water main pipe is available only in 15 ft. lengths - each length costs $280
 * -There is one intersection for every mile of road
 * -Stoplights cost $32,000 per light
 * -Each intersection has two stoplights, plus one additional stoplight for
 *  each lane
 * -Work days are 8-hour days
 * -All workers are paid $24 per hour.
 * -Crew members can complete an amount of work in a specified time according
 *  to the equation and table below:
 * 
 * crew_members = (50 * miles_of_road * number_of_lanes) / days_to_complete
 * 
 * crew members | miles | lanes | days to complete
 * 1            | 1     | 1     | 50
 * 1            | 1     | 2     | 100
 * 1            | 2     | 1     | 100
 * 1            | 2     | 2     | 200
 * 2            | 1     | 1     | 25
 * 2            | 1     | 2     | 50
 * 2            | 2     | 1     | 50
 * 2            | 2     | 2     | 100
 */
public class Construction {

    // Private constructor to hide the implicit public one
    private Construction() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static int numberOfStoplights(double miles, int lanes) {
        return ((lanes + 2) * (int) (miles));
    }

    public static int truckloadsOfAsphalt(double miles, int lanes, int inches) {
        final double MILE = 5280.0;
        final double LANE = 12.0;
        final double FOOT = 12.0;
        final double TON = 2000.0;
        final double ASPHALT = 150.0;
        final double CAPACITY = 5.0;
        double cubicFootPounds = (((miles * MILE) * (lanes * LANE) * (inches / FOOT)) * ASPHALT);
        return (int) Math.ceil(((cubicFootPounds) / TON) / CAPACITY);
    }

    public static int numberOfPowerPipes(double miles) {
        final double MILE = 5280.0;
        final double LENGTH = 20.0;
        double feet = miles * MILE;
        return (int)Math.ceil(feet / LENGTH);
    }

    public static int numberOfWaterPipes(double miles) {
        final double MILE = 5280.0;
        final double LENGTH = 15.0;
        double feet = miles * MILE;
        return (int)Math.ceil(feet / LENGTH);
    }

    public static int crewMembers(double miles, int lanes, int days) {
        return (int) Math.ceil((50 * miles * lanes) / days);
    }
}
