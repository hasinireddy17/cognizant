use event_management;


-- Q1:User upcoming Events
SELECT u.full_name,e.title,e.city,e.start_date,r.registration_date
		FROM Users u
        INNER JOIN Registrations r
        ON u.user_id=r.user_id
        INNER JOIN Events e
        ON e.event_id=r.event_id
        WHERE e.status='upcoming'
        AND u.city=e.city
        ORDER BY e.start_date;
        
        
-- Q2: Top rated Events
SELECT e.title,AVG(f.rating) as avg_rating
	FROM Events e
    INNER JOIN Feedback f
    ON e.event_id=f.event_id
    GROUP BY e.event_id,e.title
    HAVING COUNT(f.feedback_id) >= 10
    ORDER BY avg_rating DESC
    LIMIT 1;
    
    
-- Q3: Inactive Users
SELECT u.user_id,u.full_name
	FROM Users u
	LEFT JOIN Registrations r
	ON u.user_id = r.user_id
	AND r.registration_date >= CURDATE() - INTERVAL 90 DAY
	WHERE r.registration_id IS NULL;


-- Q4: Peak Session hours
SELECT e.title,COUNT(s.session_id) AS session_count
	FROM Events e
	INNER JOIN Sessions s
	ON e.event_id = s.event_id
	WHERE TIME(s.start_time) >= '10:00:00'
	AND TIME(s.end_time) <= '12:00:00'
	GROUP BY e.event_id, e.title;
    
    
-- Q5: Most Active Cities
SELECT u.city,COUNT(DISTINCT r.user_id) AS registration_count
	FROM Users u
	INNER JOIN Registrations r
	ON u.user_id = r.user_id
	GROUP BY u.city
	ORDER BY registration_count DESC
	LIMIT 5;
    
    
-- Q6: Event Resource Summary
SELECT e.title,COUNT(r.resource_id) AS resource_count
	FROM Events e
	INNER JOIN Resources r
	ON e.event_id = r.event_id
	GROUP BY e.event_id, e.title;


-- Q7: Low Feedback ALerts
SELECT u.user_id,u.full_name,f.comments,e.title
	FROM Users u
    INNER JOIN Feedback f
    ON u.user_id=f.user_id
    INNER JOIN Events e
    ON e.event_id=f.event_id
    WHERE f.rating<3;
    
    
-- Q8: Sessions per Upcoming Event
SELECT e.title,COUNT(s.session_id) as session_count
	FROM Events e
    LEFT JOIN Sessions s
    ON e.event_id=s.event_id
    WHERE e.status = 'upcoming'
    GROUP BY e.event_id,e.title;
    
    
-- Q9: Organizer Event Summary 
SELECT u.full_name,e.status,COUNT(*) AS total_events
	FROM Users u
	INNER JOIN Events e
	ON u.user_id = e.organizer_id
	GROUP BY u.user_id,u.full_name,e.status;
    
    
-- Q10: Feedback Gap
SELECT DISTINCT e.event_id,e.title
	FROM Events e
    INNER JOIN Registrations r
    ON e.event_id=r.event_id
    LEFT JOIN Feedback f
    ON r.event_id=f.event_id
    WHERE f.feedback_id IS NULL;
    
    
-- Q11: Daily new User count
SELECT registration_Date , COUNT(*) as new_User_count
	FROM Users
    WHERE registration_date >= CURDATE()-INTERVAL 7 DAY
	GROUP BY registration_date
	ORDER BY registration_date;

	
-- Q12: Event with maximum Sessions
SELECT e.event_id,COUNT(s.session_id) as sessions
	FROM Events e
    INNER JOIN Sessions s
    ON e.event_id=s.event_id
    GROUP BY e.event_id
    ORDER BY sessions DESC
    LIMIT 1;
    
    
-- Q13: Average rating per City
SELECT e.city,AVG(f.rating) as avg_rating
	FROM Events e
    INNER JOIN Feedback f
    ON e.event_id=f.event_id
    GROUP BY e.city;
    
    
-- Q14: Most Registered Events
SELECT e.event_id,e.title,COUNT(r.registration_id) as registration_count
	FROM Users u
    INNER JOIN Registrations r
    ON u.user_id=r.user_id
    INNER JOIN Events e
    ON e.event_id=r.event_id
    GROUP BY e.event_id,e.title
    ORDER BY registration_count DESC
    LIMIT 3;
    
    
-- Q15: Event Sessions Time Conflict
SELECT e.title,s1.session_id AS session1,s2.session_id AS session2
	FROM Sessions s1
    INNER JOIN Sessions s2
    ON s1.event_id=s2.event_id
		AND s1.session_id<s2.session_id
        AND s1.start_time<s2.end_time
        AND s1.end_time>s2.start_time
	INNER JOIN Events e
    ON e.event_id=s1.event_id;
    
    
-- Q16: Unregistered Active users
SELECT u.user_id,u.full_name
	FROM Users u
    LEFT JOIN Registrations r
    ON u.user_id=r.user_id
    WHERE u.registration_date>= CURDATE()-INTERVAL 30 DAY
    AND r.registration_id IS NULL;
    
    
-- Q17: Multi Sessions speakers
SELECT s1.speaker_name 
	FROM Sessions s1
    Join Sessions s2
    ON s1.speaker_name=s2.speaker_name
    AND s1.session_id<s2.session_id;
    
    
-- Q18: Resource Availability check
SELECT e.event_id,e.title
	FROM Events e
    LEFT JOIN Resources r
    ON e.event_id=r.event_id
    WHERE r.resource_id IS NULL;
    
    
-- Q19: Completed Events with Feedback Summary
SELECT e.event_id,e.title,COUNT(DISTINCT r.registration_id) as registrations,AVG(f.rating) as average_rating
	FROM Events e
    INNER JOIN Registrations r
    ON e.event_id=r.event_id
    AND e.status='completed'
    INNER JOIN Feedback f
    ON e.event_id=f.event_id
    GROUP BY e.event_id,e.title;
    
    
-- Q20: User Engagement Index
SELECT u.user_id,u.full_name,COUNT(DISTINCT r.event_id) AS registered_events,COUNT(DISTINCT f.feedback_id) AS feedback_count
	FROM Users u
	LEFT JOIN Registrations r
	ON u.user_id = r.user_id
	LEFT JOIN Feedback f
	ON u.user_id = f.user_id
	GROUP BY u.user_id, u.full_name;
    
    
-- Q21: Top Feedback Providers
SELECT u.user_id,u.full_name,COUNT(f.feedback_id) as feedbacks
	FROM Users u
    INNER JOIN Feedback f
    ON u.user_id=f.user_id
    GROUP BY u.user_id,u.full_name
    ORDER BY feedbacks DESC
    LIMIT 5;
    
    
-- Q22: Duplicate Registration check
SELECT r1.user_id
	FROM Registrations r1
    JOIN Registrations r2
    ON r1.user_id=r2.user_id
    AND r1.registration_id<r2.registration_id
    AND r1.event_id = r2.event_id;
	
    
-- Q23: Registration Trends
SELECT YEAR(registration_date) AS Year,MONTH(registration_date) as Month,COUNT(registration_id) AS registrations
	FROM Registrations 
    WHERE registration_date>=CURDATE()-INTERVAL 12 MONTH 
    GROUP BY Year,Month
    ORDER BY Year,Month;
    

-- Q24: Average Session duration per Event
SELECT e.event_id,e.title,AVG(TIMESTAMPDIFF(MINUTE,s.start_time,s.end_time)) AS avg_duration
	FROM Events e
	INNER JOIN Sessions s
	ON e.event_id = s.event_id
	GROUP BY e.event_id, e.title;
    
    
-- Q25: Events without Sessions
SELECT e.event_id,e.title
	FROM Events e
    LEFT JOIN Sessions s
    ON e.event_id=s.event_id
    WHERE s.session_id IS NULL;