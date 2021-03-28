library ieee;
use ieee.std_logic_1164.all;

entity Register_N is
	generic(N : positive :=32);
	port(	clk: in std_logic;
			enable: in std_logic;
			dIn: in std_logic_vector(N-1 downto 0);	
			dOut : out std_logic_vector(N-1 downto 0));
			
end Register_N;

architecture Behavioral of Register_N is 

	signal s_memory : std_logic_vector(N-1 downto 0);
begin
	
	process(clk, enable)
	begin
	
		if(rising_edge(clk)) then
			if(enable = '1') then
				s_memory <= dIn;
			end if;
		end if;
	end process;
	
	dOut <= s_memory;
	
end Behavioral;