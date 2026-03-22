# Wireshark Analysis – Port Scan Detection

## Objective
Analyze network traffic to identify signs of a port scanning attempt.

## Tools Used
Wireshark

## Investigation

While reviewing packets, multiple SYN requests were observed from a single IP address targeting sequential ports.

Source IP: 192.168.1.45

The traffic pattern indicates a potential reconnaissance attempt where an attacker scans ports to identify open services.

## Findings

Large number of SYN packets
Sequential port targeting
No completed TCP handshake

## Conclusion

The traffic pattern strongly suggests a port scanning attempt.

## Skills Demonstrated

Network traffic analysis  
Threat detection  
Packet inspection
